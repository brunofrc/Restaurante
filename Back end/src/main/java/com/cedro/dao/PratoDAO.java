package com.cedro.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cedro.entity.Prato;
/**
 * Classe de acesso a Base de dados, onde estao implementados metodos
 * especificos para manipulacao de objetos do tipo {@link Prato}.
 *
 * @author bruno
 */
@Repository
@Transactional
public class PratoDAO extends GenericDAO<Prato> implements IPratoDAO {
/*
 * (non-Javadoc)
 * @see com.cedro.dao.IPratoDAO#readByExample(com.cedro.entity.Prato)
 */
	@Override
	@Transactional(readOnly = true)
	public List<Prato> readByExample(Prato prato) throws DAOException {
		Criteria criteria = getCurrentSession().createCriteria(Prato.class);
		criteria.add(Restrictions.like("nome", prato.getNome(), MatchMode.ANYWHERE));
		return criteria.list();
	}
/*
 * (non-Javadoc)
 * @see com.cedro.dao.IPratoDAO#readAllPratos()
 */
	@Override
	@Transactional(readOnly = true)
	public List<Prato> readAllPratos() throws DAOException {
		try {
			Criteria criteria = getCurrentSession().createCriteria(Prato.class);
			return criteria.list();
		} catch (HibernateException ex) {
			throw new DAOException(ex);
		} catch (Exception ex) {
			throw new DAOException(ex);
		}
	}
	
}
