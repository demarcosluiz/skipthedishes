package com.skip.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.skip.dao.service.ProductDAO;
import com.skip.dao.service.ServiceException;
import com.skip.entities.Product;

/**
 * @author Marcos.Gregorio
 *
 */
@Named("com.skip.service.ProductService")
public class ProductService extends AbstractService<ProductDAO, Product, Integer> {
	
	@Inject
	private ProductDAO productDAO;
	
	@Override
	protected ProductDAO getGenericDAO() {
		return productDAO;
	}
	
	public List<Product> listNameLike(String nameLike) throws ServiceException {
		try {
			return getGenericDAO().listNameLike(nameLike);
		
		} catch (com.skip.dao.service.DAOServiceException e) {
			//logger.log(Level.ERROR, "Error logCTFService.buscar", e);
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Product> listByStore(Integer storeId) throws ServiceException {
		try {
			return getGenericDAO().listByStore(storeId);
		
		} catch (com.skip.dao.service.DAOServiceException e) {
			//logger.log(Level.ERROR, "Error logCTFService.buscar", e);
			e.printStackTrace();
		}
		return null;
	}
	
}
