package com.skip.dao.service;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @author Marcos.Gregorio
 * @date   05/06/2015
 *
 */
public class DAOServiceImpl<EntityType, PKType> implements DAOService<EntityType, PKType> { 
	
	//protected Logger logger = GestorChavesLogger.getDAO();
	
	private Class<EntityType> persistentClass;
	
	@PersistenceContext(unitName="persistenceUnit")
	private EntityManager entityManager;
	
	
	@SuppressWarnings("unchecked")
	public DAOServiceImpl() {
		
		persistentClass = (Class<EntityType>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		
		/*
		//TODO
		try {	
			//compatibilidade glassfish 3
			persistentClass = (Class<EntityType>) ((ParameterizedType) getClass()
					.getGenericSuperclass()).getActualTypeArguments()[0];
		} catch (Exception e) {}
			
		try {
			//compatibilidade weblogic 12c
			if (persistentClass == null) {
				Class<EntityType> superClass = (Class<EntityType>)getClass().getSuperclass();
				persistentClass = (Class<EntityType>) ((ParameterizedType) superClass
									.getGenericSuperclass()).getActualTypeArguments()[0];
			} 
		} catch (Exception e) {}
		*/
	}

	public Class<EntityType> getPersistentClass() {
		return persistentClass;
	}
	
	protected EntityManager getEntityManager(){
		return entityManager;
	}
	
	
	//TODO @Override
	//TODO begin e commit
	//@TransactionAttribute(TransactionAttributeType.REQUIRED)
	
	//@Transactional(propagation=Propagation.REQUIRED)
	public void save(EntityType entityType) throws DAOServiceException {
		//UserTransaction utx = (UserTransaction) entityManager.getTransaction();
		 
		if (entityType == null) {
			throw new IllegalArgumentException(" invalid entity " + getPersistentClass().getSimpleName());
		}

		try {
			
//			utx.begin();
			
			PKType pkType = getValuePk(entityType);
			if (pkType != null) {
				entityType = entityManager.merge(entityType);
			} else {
				entityManager.persist(entityType);
			}
			
			//entityManager.flush();
			//utx.commit();
		} catch (Exception e) {
			//logger.error(e.getMessage(), e);
			throw new DAOServiceException("persist error in " + getPersistentClass().getSimpleName() + ". " + e.getMessage(), e);
		}
	}

	@SuppressWarnings("unchecked")
	//TODO @Override
	//@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public EntityType searchID(PKType pkType) throws DAOServiceException{
		if (pkType == null) {
			throw new IllegalArgumentException("pk invalida para " + getPersistentClass().getSimpleName());
		}
		
		try {
			
			String queryName = getPersistentClass().getSimpleName() 
						+ ".buscaPorId";
			
			Query query = null;
			try {
				query = entityManager.createNamedQuery(queryName);
			}catch (Exception e) {
				//logger.debug(queryName + " inexistent.");
			}
			
			EntityType entityType = null;
			if (query != null) {
				query.setParameter("id", pkType);
				Object obj = query.getSingleResult();
				if (obj != null) {
					entityType = (EntityType) obj;
				}
			} else {
				entityType = (EntityType) entityManager.find(getPersistentClass(), pkType);	
			}
			
			return entityType;
		} catch (Exception e) {
			//logger.error(e.getMessage(), e);
			throw new DAOServiceException("entidade " 
					+ getPersistentClass().getSimpleName() + " not found using pk. "
					+ e.getMessage(),e);
		}
	}

	@SuppressWarnings("unchecked")
	//TODO @Override
	//@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public EntityType searchDetailByID(PKType pkType) throws DAOServiceException{
		if (pkType == null) {
			throw new IllegalArgumentException(" invalid pk for " + getPersistentClass().getSimpleName());
		}
		
		try {
			
			String queryName = getPersistentClass().getSimpleName() 
						+ ".buscaDetalhadaPorId";
			
			Query query = entityManager.createNamedQuery(queryName);
			query.setParameter("id", pkType);
			Object obj = query.getSingleResult();
			if (obj != null) {
				return (EntityType) obj;
			}
			return null;
		} catch (Exception e) {
			//logger.error(e.getMessage(), e);
			throw new DAOServiceException("entity " 
					+ getPersistentClass().getSimpleName() + " not found using pk. "
					+ e.getMessage(),e);
		}
	}
	
	//TODO @Override
	//@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remove(PKType pkType) throws DAOServiceException {
		entityManager.remove(pkType);
//		if (entityManagerSegundoSite != null) {
//			entityManagerSegundoSite.remove(pkType);
//		}
		
	}
	
	//TODO @Override	
	//@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<EntityType> list() throws DAOServiceException {
		return list(0, 0);
	}
	
	//TODO @Override
	@SuppressWarnings("unchecked")	
	//@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<EntityType> list(int max, int pagina) throws DAOServiceException {
		try {
			String entityType = getPersistentClass().getSimpleName() 
					+ ".list";
			Query query = entityManager.createNamedQuery(entityType);
			
			configPaginacao(query, max, pagina);
			
			List<EntityType> list = (List<EntityType>) query.getResultList();
			return (list != null && !list.isEmpty()) ? list : Collections.EMPTY_LIST;
		} catch (Exception e) {	
			//logger.error(e.getMessage(), e);
			throw new DAOServiceException("error in listing " +
					getPersistentClass().getSimpleName() + ". " + e.getMessage() ,	e);
		}
	}
	
	protected void configPaginacao(Query query, int max, int pagina) {
		if (max > 0) {
			query.setMaxResults(max);
			query.setFirstResult(pagina * max);
		}
	}
	
	public void detach(EntityType entityType) throws DAOServiceException {
		try {
			entityManager.detach(entityType);
//			if (entityManagerSegundoSite != null) {
//				entityManagerSegundoSite.detach(entityType);
//			}
		} catch (Exception e) {
			throw new DAOServiceException(e.getMessage(), e);
		}
	}
	
	@SuppressWarnings("unchecked")	
	private PKType getValuePk(EntityType entityType){
		Field field = getFieldPk(entityType.getClass());
		if (field != null){
			try {
				return (PKType)field.get(entityType);
			} catch (IllegalArgumentException e) {
			} catch (IllegalAccessException e) {
			}
		}
		return null;
	}
	
	private Field getFieldPk(Class<?> entityType){
		Field fieldID = null;
		Field[] fields = entityType.getDeclaredFields();
		if (fields != null){
			for (Field field : fields) {
				if (field.isAnnotationPresent(Id.class)
						|| field.isAnnotationPresent(IdClass.class)
						|| field.isAnnotationPresent(EmbeddedId.class)){
					if (!field.isAccessible()){
						field.setAccessible(true);
					}
					return field;
				}
			}
		}
		
		Class<?> superClass = entityType.getSuperclass();
		if (superClass != null 
				&& !(superClass.equals(Object.class))){
			fieldID = getFieldPk(superClass);
		}		
		return fieldID;
	}

	
}
