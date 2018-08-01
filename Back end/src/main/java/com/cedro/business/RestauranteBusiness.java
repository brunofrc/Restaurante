package com.cedro.business;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cedro.dao.DAOException;
import com.cedro.dao.RestauranteDAO;
import com.cedro.entity.Restaurante;

/**
 * Classe onde estao implementados metodos especificos disponibilizados pela
 * camada de negocio, para manipulacao de objetos {@link Restaurante}.
 *
 * @author bruno
 */
@Component
@Transactional
public class RestauranteBusiness extends GenericBusiness<Restaurante, RestauranteDAO> implements IRestauranteBusiness {
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cedro.business.IRestauranteBusiness#readByExample(com.cedro.entity.
	 * Restaurante)
	 */
	@Override
	public List<Restaurante> readByExample(Restaurante entity) throws BusinessException {
		try {
			if (entity.getNome() == null) {
				throw new BusinessException("Nome requerido para pesquisa");
			}
			return getDAO().readByExample(entity);
		} catch (DAOException ex) {
			throw new BusinessException(ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cedro.business.IRestauranteBusiness#readAllRestaurantes()
	 */
	@Override
	public List<Restaurante> readAllRestaurantes() throws BusinessException {
		try {
			return getDAO().readAllRestaurantes();
		} catch (DAOException ex) {
			throw new BusinessException(ex);
		}
	}
}
