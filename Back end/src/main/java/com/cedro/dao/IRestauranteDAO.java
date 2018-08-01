package com.cedro.dao;

import java.util.List;

import com.cedro.entity.Prato;
import com.cedro.entity.Restaurante;
/**
 * Interface de acesso a Base de dados, onde estao definidos metodos especificos
 * para manipulacao de objetos do tipo {@link Prato}.
 *
 * @author bruno
 */
public interface IRestauranteDAO extends IGenericDAO<Restaurante>{
	/**
	 * Metodo responsavel por recuperar todos os restaurantes com base em um restaurante pre definido
	 * @param restaurante
	 * @return
	 * @throws DAOException
	 */
public List<Restaurante> readByExample(Restaurante restaurante) throws DAOException;
/**
 * Metodo responsavel por recuperar todos os restaurantes
 * @param restaurante
 * @return
 * @throws DAOException
 */
public List<Restaurante> readAllRestaurantes() throws DAOException;
}
