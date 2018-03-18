package com.skip.dao.service;

import java.util.List;

import com.skip.entities.Cousine;

/**
 * @author Marcos.Gregorio
 *
 */

public interface CousineDAO extends DAOService<Cousine, Integer> {
	
	public List<Cousine> listNameLike(String nameLike) throws ServiceException;
	
}
