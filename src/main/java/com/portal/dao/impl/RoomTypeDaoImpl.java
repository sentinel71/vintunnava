package com.portal.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.portal.beans.SearchDetails;
import com.portal.dao.RoomTypeDao;
import com.portal.model.Roomtype;

@Component
public class RoomTypeDaoImpl implements RoomTypeDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<Roomtype> findbySearchCriteria(SearchDetails searchBean) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("rateplanid", 1);
		//parameters.put("houseboatid", searchBean.getHouseboatId()+"");
//		Query query = entityManager.createNamedQuery(Roomtype.FIND_ROOMS_BY_USER);
//		for(Entry<String, Object> entry:parameters.entrySet())
//			query.setParameter(entry.getKey(), entry.getValue());

		Query query = entityManager.createQuery("select r from Roomtype r");
		return query.getResultList();
	}

}
