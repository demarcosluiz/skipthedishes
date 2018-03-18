package com.skip.dao.service;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.skip.entities.Product;

/**
 * @author Marcos.Gregorio
 *
 */
@Named("com.skip.dao.service.ProductDAOImpl")
public class ProductDAOImpl extends DAOServiceImpl<Product, Integer> implements ProductDAO {
	
	@Override
	public List<Product> listNameLike(String nameLike) throws ServiceException {
		EntityManager entityManager = getEntityManager();
		
		try {
			Query query = entityManager.createNamedQuery("Product.listNameLike");
			query.setParameter("nameLike", "%" + nameLike + "%");
			
			List<Product> list = query.getResultList();
			
			return list;
			
		} catch (NoResultException e) {
			return null;
			
		} catch (Exception e) {
//				logger.log(Level.ERROR, msgErro);
			e.printStackTrace();
			throw new DAOServiceException(e.getMessage(), e);
		}
	}

	@Override
	public List<Product> listByStore(Integer storeId) throws ServiceException {
		EntityManager entityManager = getEntityManager();
		
		try {
			Query query = entityManager.createNamedQuery("Product.listByStore");
			query.setParameter("storeId", storeId);
			
			List<Product> list = query.getResultList();
			
			return list;
			
		} catch (NoResultException e) {
			return null;
			
		} catch (Exception e) {
//				logger.log(Level.ERROR, msgErro);
			e.printStackTrace();
			throw new DAOServiceException(e.getMessage(), e);
		}
	}
	
	/*
	@Override
	public boolean auth(String email, String password) {
		
		EntityManager entityManager = getEntityManager();
		
		try {
			Query query = entityManager.createNamedQuery("Customer.auth");
			query.setParameter("email", email);
			query.setParameter("password", password);
			
			query.setMaxResults(1);
			Customer customer = (Customer) query.getSingleResult();
			
			return true;
			
		} catch (NoResultException e) {
			return false;
			
		} catch (Exception e) {
//				String msgErro = "LogCTFDAOImpl.busca: Não foi possível realizar a consulta: empresa=" + empresa + ", loja=" + loja + ", dataTransacao=" + dataTransacao + ", nsuCTF=" + nsuCTF + ". Err Desc: " + e.getMessage();
//				logger.log(Level.ERROR, msgErro);
			e.printStackTrace();
			throw new DAOServiceException(e.getMessage(), e);
		}
	}
	*/
	
	
}
