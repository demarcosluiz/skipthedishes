package com.skip.dao.service;

import com.skip.entities.Customer;

/**
 * @author Marcos.Gregorio
 *
 */

public interface CustomerDAO extends DAOService<Customer, Integer> {
	
	public boolean auth(String email, String password);
	
}
