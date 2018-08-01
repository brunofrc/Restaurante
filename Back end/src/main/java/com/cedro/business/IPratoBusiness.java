package com.cedro.business;

import java.util.List;

import com.cedro.dao.PratoDAO;
import com.cedro.entity.Prato;

/**
 * Interface de Negocio, onde estao definidos metodos especificos para
 * manipulacao de objetos do tipo @Link{Prato}.
 *
 * @author bruno
 */
public interface IPratoBusiness extends IGenericBusiness<Prato, PratoDAO> {
	/**
	 * Metodo responsavel por solicitar a camada DAO que recupere todos os pratos
	 * com base em um restaurante pre definido
	 * 
	 * @param entity
	 * @return
	 * @throws BusinessException
	 */
	public List<Prato> readByExample(Prato entity) throws BusinessException;

	/**
	 * Metodo responsavel por solicitar a camada DAO que recupere todos os pratos
	 * 
	 * @param entity
	 * @return
	 * @throws BusinessException
	 */
	public List<Prato> readAllPratos() throws BusinessException;
}
