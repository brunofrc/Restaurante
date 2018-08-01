package com.cedro.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cedro.entity.Restaurante;

/**
 * Classe de acesso a Base de dados, onde estao implementados metodos
 * especificos para manipulacao de objetos do tipo {@link Restaurante}.
 *
 * @author bruno
 */
@Repository
@Transactional
public class RestauranteDAO extends GenericDAO<Restaurante> implements IRestauranteDAO {
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cedro.dao.IRestauranteDAO#readByExample(com.cedro.entity.Restaurante)
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Restaurante> readByExample(Restaurante restaurante) throws DAOException {
		Criteria criteria = getCurrentSession().createCriteria(Restaurante.class);
		criteria.add(Restrictions.like("nome", restaurante.getNome(), MatchMode.ANYWHERE));
		return criteria.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cedro.dao.IRestauranteDAO#readAllRestaurantes()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Restaurante> readAllRestaurantes() throws DAOException {
		try {
			Criteria criteria = getCurrentSession().createCriteria(Restaurante.class);
			return criteria.list();
		} catch (HibernateException ex) {
			throw new DAOException(ex);
		} catch (Exception ex) {
			throw new DAOException(ex);
		}

	}

}
