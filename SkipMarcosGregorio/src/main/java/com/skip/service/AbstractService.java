package com.skip.service;

import java.io.Serializable;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.skip.constants.ConstantsSkip;
import com.skip.dao.service.DAOService;
import com.skip.dao.service.DAOServiceException;
import com.skip.dao.service.QueryNoResultException;
import com.skip.dao.service.ServiceException;
import com.skip.entities.AbstractEntity;


public abstract class AbstractService<
	GenericDAO extends DAOService<EntityType, PkType>,
	EntityType extends AbstractEntity<PkType>,
	PkType extends Serializable> extends BaseService {
	
	
	public AbstractService() {

	}

	protected abstract GenericDAO getGenericDAO();
	
	public EntityType searchID(PkType id) throws ServiceException {
		try {
			return (EntityType) getGenericDAO().searchID(id);
			
		} catch (DAOServiceException e) {
			if (e.getCause() instanceof NoResultException) {
				throw new QueryNoResultException(ConstantsSkip.CodigoErro.GENERIC, e.getMessage(), e);
			}
			throw new ServiceException(ConstantsSkip.CodigoErro.GENERIC, e.getMessage(), e);
		}
	}
	
	public EntityType searchDetailByID(PkType id) throws ServiceException {
		try {
			return (EntityType)getGenericDAO().searchDetailByID(id);
		} catch (DAOServiceException e) {
			if (e.getCause() instanceof NoResultException) {
				throw new QueryNoResultException(ConstantsSkip.CodigoErro.GENERIC, e.getMessage(), e);
			}
			throw new ServiceException(ConstantsSkip.CodigoErro.GENERIC, e.getMessage(), e);
		}
	}
	
	//@Transactional(propagation=Propagation.REQUIRED)
	@Transactional(propagation=Propagation.REQUIRED)
	public void save(EntityType entityType) throws ServiceException {
		try {
			/*
			if (entityType.getTableId() == null) {
				//entityType.setDataCriacao(new Date());
				
				if (entityType instanceof AbstractEntityNoDelete) {
					AbstractEntityNoDelete<PkType> obj = (AbstractEntityNoDelete<PkType>) entityType;
					obj.setStatus(1);
				}
				
			}			
			//entityType.setDataAlteracao(new Date());
			*/
			
			getGenericDAO().save(entityType);
			//getGenericDAO().saveSegundoSite(entityType);
			
		} catch (DAOServiceException e) {
			throw new ServiceException(ConstantsSkip.CodigoErro.GENERIC, e.getMessage(), e);
		}
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void update(EntityType entityType) throws ServiceException {
		save(entityType);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void remove(PkType id) throws ServiceException {
		try {
			getGenericDAO().remove(id);
		} catch (DAOServiceException e) {
			throw new ServiceException(ConstantsSkip.CodigoErro.GENERIC, e.getMessage(), e);
		}
	}
	
	public List<EntityType> list() throws ServiceException {
		try {
			return getGenericDAO().list(20, 0);
		} catch (DAOServiceException e) {
			throw new ServiceException(ConstantsSkip.CodigoErro.GENERIC, e.getMessage(), e);
		}
	}
	
	public List<EntityType> list(int max, int pagina) throws ServiceException {
		try {
			return getGenericDAO().list(max, pagina);
		} catch (DAOServiceException e) {
			throw new ServiceException(ConstantsSkip.CodigoErro.GENERIC, e.getMessage(), e);
		}
	}
	
	public void detach(EntityType entityType) throws ServiceException {
		try {
			getGenericDAO().detach(entityType);
		} catch (DAOServiceException e) {
			throw new ServiceException(ConstantsSkip.CodigoErro.GENERIC, e.getMessage(), e);
		}
	}
	
}
