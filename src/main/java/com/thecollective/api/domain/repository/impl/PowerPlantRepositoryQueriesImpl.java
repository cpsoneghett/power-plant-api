package com.thecollective.api.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.Predicate;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.thecollective.api.domain.dto.FilterDto;
import com.thecollective.api.domain.entity.PowerPlant;
import com.thecollective.api.domain.repository.PowerPlantRepositoryQueries;

@Repository
public class PowerPlantRepositoryQueriesImpl implements PowerPlantRepositoryQueries {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<PowerPlant> findByCriteria(Pageable pageable, FilterDto filter) {

		var builder = em.getCriteriaBuilder();

		var criteria = builder.createQuery(PowerPlant.class);
		var root = criteria.from(PowerPlant.class);

		var predicates = new ArrayList<Predicate>();

		if (StringUtils.hasLength(filter.getState())) {
			predicates.add(builder.like(root.get("state"), "%" + filter.getState().toUpperCase() + "%"));
		}

		criteria.where(predicates.toArray(new Predicate[0]));

		TypedQuery<PowerPlant> typedQuery = em.createQuery(criteria);

		typedQuery.setFirstResult(pageable.getPageNumber());
		typedQuery.setMaxResults(pageable.getPageSize());

		return em.createQuery(criteria).getResultList();
	}

}
