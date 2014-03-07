package com.portal.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.portal.dao.HouseBoatDao;
import com.portal.model.Houseboattype;

public class HouseBoatDaoImpl implements HouseBoatDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public List<Houseboattype> findAll() {
		Query q = entityManager.createQuery("select h from Houseboattype h");
		List<Houseboattype> list=q.getResultList();
		return list;
	}

}
