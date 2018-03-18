package com.skip.dao.service;

import java.util.List;

/**
 * @author Marcos.Gregorio
 *
 */
public interface DAOService<EntityType, PKType> {
	
	public EntityType searchID(PKType pkType) throws DAOServiceException;

	
	public EntityType searchDetailByID(PKType pkType) throws DAOServiceException;
	
	public void save(EntityType entityType) throws DAOServiceException;
	
	public void remove(PKType pkType) throws DAOServiceException;

	public List<EntityType> list() throws DAOServiceException;
	
	public List<EntityType> list(int max, int pagina) throws DAOServiceException;
	
	public void detach(EntityType entityType) throws DAOServiceException;
}
