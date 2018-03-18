package com.skip.dao.service;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.skip.entities.Store;

/**
 * @author Marcos.Gregorio
 *
 */
@Named("com.skip.dao.service.StoreDAOImpl")
public class StoreDAOImpl extends DAOServiceImpl<Store, Integer> implements StoreDAO {
	
	@Override
	public List<Store> listByCousine(Integer cousineId) {
		
		EntityManager entityManager = getEntityManager();
		
		try {
			Query query = entityManager.createNamedQuery("Store.listByCousine");
			query.setParameter("cousineId", cousineId);
			
			//query.setMaxResults(1);
			List<Store> listStore = query.getResultList();
			
			return listStore;
			
		} catch (NoResultException e) {
			return null;
			
		} catch (Exception e) {
//				logger.log(Level.ERROR, msgErro);
			e.printStackTrace();
			throw new DAOServiceException(e.getMessage(), e);
		}
	}
	
	@Override
	public List<Store> listNameLike(String nameLike) throws ServiceException {
		EntityManager entityManager = getEntityManager();
		
		try {
			Query query = entityManager.createNamedQuery("Store.listNameLike");
			query.setParameter("nameLike", "%" + nameLike + "%");
			
			List<Store> list = query.getResultList();
			
			return list;
			
		} catch (NoResultException e) {
			return null;
			
		} catch (Exception e) {
//				logger.log(Level.ERROR, msgErro);
			e.printStackTrace();
			throw new DAOServiceException(e.getMessage(), e);
		}
	}
	
	
}
