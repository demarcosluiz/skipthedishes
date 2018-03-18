package com.skip.dao.service;

import javax.inject.Named;

import com.skip.entities.Order;

/**
 * @author Marcos.Gregorio
 *
 */
@Named("com.skip.dao.service.OrderDAOImpl")
public class OrderDAOImpl extends DAOServiceImpl<Order, Integer> implements OrderDAO {
	
	
}
