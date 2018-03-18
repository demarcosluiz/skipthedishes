package com.skip.dao.service;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.skip.entities.Customer;

/**
 * @author Marcos.Gregorio
 *
 */
@Named("com.skip.dao.service.CustomerDAOImpl")
public class CustomerDAOImpl extends DAOServiceImpl<Customer, Integer> implements CustomerDAO {
	
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
//				logger.log(Level.ERROR, msgErro);
			e.printStackTrace();
			throw new DAOServiceException(e.getMessage(), e);
		}
	}
	
	
}
