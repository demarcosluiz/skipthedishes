package com.skip.service;

import javax.inject.Inject;
import javax.inject.Named;

import com.skip.dao.service.CustomerDAO;
import com.skip.dao.service.ServiceException;
import com.skip.entities.Customer;

/**
 * @author Marcos.Gregorio
 *
 */
@Named("com.skip.service.CustomerService")
public class CustomerService extends AbstractService<CustomerDAO, Customer, Integer> {
	
	@Inject
	private CustomerDAO customerDAO;
	
	@Override
	protected CustomerDAO getGenericDAO() {
		return customerDAO;
	}
	
	public boolean auth(String email,
						  String password) throws ServiceException {
		try {
			return getGenericDAO().auth(email, password);
		
		} catch (com.skip.dao.service.DAOServiceException e) {
			//logger.log(Level.ERROR, "Error logCTFService.buscar", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
