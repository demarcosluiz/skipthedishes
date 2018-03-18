package com.skip.dao.service;

import java.util.List;

import com.skip.entities.Product;

/**
 * @author Marcos.Gregorio
 *
 */

public interface ProductDAO extends DAOService<Product, Integer> {
	
	public List<Product> listNameLike(String nameLike) throws ServiceException;
	
	public List<Product> listByStore(Integer storeId) throws ServiceException;
	
	
}
