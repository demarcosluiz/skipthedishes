package com.skip.service;

import javax.inject.Inject;
import javax.inject.Named;

import com.skip.dao.service.OrderItemDAO;
import com.skip.entities.OrderItem;

/**
 * @author Marcos.Gregorio
 *
 */
@Named("com.skip.service.OrderItemService")
public class OrderItemService extends AbstractService<OrderItemDAO, OrderItem, Integer> {
	
	@Inject
	private OrderItemDAO orderItemDAO;
	
	@Override
	protected OrderItemDAO getGenericDAO() {
		return orderItemDAO;
	}
	
	
	
}
