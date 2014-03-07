package com.portal.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.portal.dao.RouteDao;
import com.portal.model.Houseboattype;
import com.portal.model.Route;

public class RouteDaoImpl implements RouteDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public List<Route> findAll() {
		Query q = entityManager.createQuery("select r from Route r");
		List<Route> list=q.getResultList();
		return list;
	}

}
