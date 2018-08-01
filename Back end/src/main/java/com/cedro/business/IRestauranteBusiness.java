package com.cedro.business;

import java.util.List;

import com.cedro.dao.RestauranteDAO;
import com.cedro.entity.Restaurante;
/**
 * Interface de Negocio, onde estao definidos metodos especificos para
 * manipulacao de objetos do tipo @Link{Restaurante}.
 *
 * @author bruno
 */
public interface IRestauranteBusiness extends IGenericBusiness<Restaurante, RestauranteDAO> {
	/**
	 * MMetodo responsavel por solicitar a camada DAO que recupere todos os
	 * restaurantes com base em um restaurante pre definido
	 * 
	 * @param entity
	 * @return
	 * @throws BusinessException
	 */
	List<Restaurante> readByExample(Restaurante entity) throws BusinessException;

	/**
	 * Metodo responsavel por solicitar a camada DAO que recupere todos os
	 * restaurantes
	 * 
	 * @param entity
	 * @return
	 * @throws BusinessException
	 */
	List<Restaurante> readAllRestaurantes() throws BusinessException;

}
