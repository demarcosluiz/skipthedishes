package com.skip.dao.service;

import java.util.List;

import com.skip.entities.Store;

/**
 * @author Marcos.Gregorio
 *
 */

public interface StoreDAO extends DAOService<Store, Integer> {
	
	public List<Store> listByCousine(Integer cousineId);
	
	public List<Store> listNameLike(String nameLike) throws ServiceException;
	
}
