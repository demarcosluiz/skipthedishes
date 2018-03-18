package com.skip.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.skip.dao.service.ServiceException;
import com.skip.dao.service.StoreDAO;
import com.skip.entities.Store;

/**
 * @author Marcos.Gregorio
 *
 */
@Named("com.skip.service.StoreService")
public class StoreService extends AbstractService<StoreDAO, Store, Integer> {
	
	@Inject
	private StoreDAO storeDAO;
	
	@Override
	protected StoreDAO getGenericDAO() {
		return storeDAO;
	}
	
	public List<Store> listByCousine(Integer cousineId) throws ServiceException {
		try {
			return getGenericDAO().listByCousine(cousineId);
		
		} catch (com.skip.dao.service.DAOServiceException e) {
			//logger.log(Level.ERROR, "Error logCTFService.buscar", e);
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Store> listNameLike(String nameLike) throws ServiceException {
		try {
			return getGenericDAO().listNameLike(nameLike);
		
		} catch (com.skip.dao.service.DAOServiceException e) {
			//logger.log(Level.ERROR, "Error logCTFService.buscar", e);
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
}
