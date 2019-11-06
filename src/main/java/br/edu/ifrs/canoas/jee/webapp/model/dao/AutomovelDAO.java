package br.edu.ifrs.canoas.jee.webapp.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import br.edu.ifrs.canoas.jee.webapp.model.entity.Automovel;

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
	
	@SuppressWarnings("unchecked")
	public List<Automovel> busca(Automovel automovel){
		
		if(automovel == null) {
			return new ArrayList<Automovel>();
		}
		
		CriteriaQuery<Automovel> query = builder().createQuery(Automovel.class);
		Root<Automovel> from = query.from(Automovel.class);
		
		Predicate predicate = builder().and();
		
		if(!StringUtils.isBlank(automovel.getMarca())){
			predicate = builder().and(predicate, builder().like(
					from.get("marca"), automovel.getMarca().trim().toLowerCase()));
		}
		if(!StringUtils.isBlank(automovel.getModelo())) {
			predicate = builder().and(predicate, builder().like(
					from.get("modelo"), automovel.getModelo().trim().toLowerCase()));
		}
		if(!StringUtils.isBlank(automovel.getRENAVAN())) {
			predicate = builder().and(predicate, builder().like(
					from.get("RENAVAN"), automovel.getRENAVAN().trim().toLowerCase()));
		}
		if(!StringUtils.isBlank(automovel.getPlaca())) {
			predicate = builder().and(predicate, builder().like(
					from.get("placa"), automovel.getMarca().trim().toLowerCase()));
		}
		
		return em.createQuery(query.select(from)
				.where(predicate)
				.orderBy(builder().asc(from.get("placa"))))
				.getResultList();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Automovel> buscaPorCriterio(String criterio){
		return em.createQuery(
				"SELECT a "
				+ "FROM Automovel a "
				+ "WHERE lower(a.placa) = :placa "
				+ " or lower (a.modelo) = :modelo "
				+ " or lower (a.RENAVAN) = :RENAVAN "
				+ " or lower (a.marca) = :marca ")
				.setParameter("placa", criterio.trim().toLowerCase())
				.setParameter("modelo", criterio.trim().toLowerCase())
				.setParameter("RENAVAN", criterio.trim().toLowerCase())
				.setParameter("marca", criterio.trim().toLowerCase())
				.getResultList();
	}

}
