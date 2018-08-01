package com.cedro.dao;

import java.util.List;

import com.cedro.entity.Prato;
/**
 * Interface de acesso a Base de dados, onde estao definidos metodos especificos
 * para manipulacao de objetos do tipo {@link Prato}.
 *
 * @author bruno
 */
public interface IPratoDAO extends IGenericDAO<Prato>{
	/**
	 * Metodo resposnavel por recuperar todos os pratos com base em um prato pre definido
	 * @param restaurante
	 * @return
	 * @throws DAOException
	 */
	public List<Prato> readByExample(Prato prato) throws DAOException;
	/**
	 * Metodo resposnavel por recuperar todos os pratos
	 * @param prato
	 * @return
	 * @throws DAOException
	 */
	public List<Prato> readAllPratos() throws DAOException;
}
