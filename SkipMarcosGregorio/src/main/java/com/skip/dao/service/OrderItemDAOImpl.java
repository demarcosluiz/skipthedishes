package com.skip.dao.service;

import javax.inject.Named;

import com.skip.entities.OrderItem;

/**
 * @author Marcos.Gregorio
 *
 */
@Named("com.skip.dao.service.OrderItemDAOImpl")
public class OrderItemDAOImpl extends DAOServiceImpl<OrderItem, Integer> implements OrderItemDAO {
	
	
}
