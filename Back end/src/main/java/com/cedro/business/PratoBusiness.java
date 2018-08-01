package com.cedro.business;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cedro.dao.DAOException;
import com.cedro.dao.PratoDAO;
import com.cedro.entity.Prato;

/**
 * Classe onde estao implementados metodos especificos disponibilizados pela
 * camada de negocio, para manipulacao de objetos {@link Prato}.
 *
 * @author bruno
 */
@Component
@Transactional
public class PratoBusiness extends GenericBusiness<Prato, PratoDAO> implements IPratoBusiness {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cedro.business.IPratoBusiness#readAllPratos()
	 */
	@Override
	public List<Prato> readAllPratos() throws BusinessException {
		try {
			return getDAO().readAllPratos();
		} catch (DAOException ex) {
			throw new BusinessException(ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cedro.business.IPratoBusiness#readByExample(com.cedro.entity.Prato)
	 */
	@Override
	public List<Prato> readByExample(Prato entity) throws BusinessException {
		try {
			return getDAO().readAllPratos();
		} catch (DAOException ex) {
			throw new BusinessException(ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cedro.business.GenericBusiness#delete(java.lang.Object)
	 */
	@Override
	public void delete(Prato entity) throws BusinessException {
		entity.setRestaurante(null);
		super.delete(entity);
	}

}
