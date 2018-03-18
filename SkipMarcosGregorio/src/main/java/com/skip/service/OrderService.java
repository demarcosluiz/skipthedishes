package com.skip.service;

import javax.inject.Inject;
import javax.inject.Named;

import com.skip.dao.service.OrderDAO;
import com.skip.entities.Order;

/**
 * @author Marcos.Gregorio
 *
 */
@Named("com.skip.service.OrderService")
public class OrderService extends AbstractService<OrderDAO, Order, Integer> {
	
	@Inject
	private OrderDAO orderDAO;
	
	@Override
	protected OrderDAO getGenericDAO() {
		return orderDAO;
	}
	
	
	
}
