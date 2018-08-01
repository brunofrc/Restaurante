package com.cedro.business;

/**
 * Classe generica onde estao implementados metodos genericos disponibilizados
 * pela camada de negocio, para manipulacao de objetos.
 *
 * @author bruno
 */
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cedro.dao.DAOException;
import com.cedro.dao.GenericDAO;

public class GenericBusiness<E, DAO extends GenericDAO> implements IGenericBusiness<E, DAO> {
	@Autowired
	private DAO dao;

	public GenericBusiness() {
	}

	/**
	 * Metodo responsavel por recuperar o atributo dao
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public DAO getDAO() throws BusinessException {
		return dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cedro.business.IGenericBusiness#create(java.lang.Object)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public E create(E entity) throws BusinessException {
		try {
			return (E) getDAO().create(entity);
		} catch (DAOException ex) {
			throw new BusinessException(ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cedro.business.IGenericBusiness#update(java.lang.Object)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public E update(E entity) throws BusinessException {
		try {
			return (E) getDAO().update(entity);
		} catch (DAOException ex) {
			throw new BusinessException(ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cedro.business.IGenericBusiness#delete(java.lang.Object)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(E entity) throws BusinessException {
		try {
			getDAO().delete(entity);
		} catch (DAOException ex) {
			throw new BusinessException(ex);
		}
	}

}
