package br.edu.ifrs.canoas.jee.webapp.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import br.edu.ifrs.canoas.jee.webapp.model.entity.Automovel;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Usuario;

@Stateless
public class AutomovelDAO extends BaseDAO<Automovel, Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings ("unchecked")
	public List<Automovel> buscaPorPlaca(String placa){
		return em.createQuery("SELECT a FROM Automovel a "+" WHERE lower(a.placa) = :placa ")
				.setParameter("placa", placa).getResultList();
	}
	

}
