package com.skip.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.skip.dao.service.CousineDAO;
import com.skip.dao.service.ServiceException;
import com.skip.entities.Cousine;

/**
 * @author Marcos.Gregorio
 *
 */
@Named("com.skip.service.CousineService")
public class CousineService extends AbstractService<CousineDAO, Cousine, Integer> {
	
	@Inject
	private CousineDAO cousineDAO;
	
	@Override
	protected CousineDAO getGenericDAO() {
		return cousineDAO;
	}
	
	public List<Cousine> listNameLike(String nameLike) throws ServiceException {
		try {
			return getGenericDAO().listNameLike(nameLike);
		
		} catch (com.skip.dao.service.DAOServiceException e) {
			//logger.log(Level.ERROR, "Error logCTFService.buscar", e);
			e.printStackTrace();
		}
		return null;
	}
	
}
