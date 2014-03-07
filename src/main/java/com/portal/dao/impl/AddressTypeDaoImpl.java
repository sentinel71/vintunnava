package com.portal.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.portal.dao.AddressTypeDao;
import com.portal.model.Addresstype;

public class AddressTypeDaoImpl implements AddressTypeDao{
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<Addresstype> findAll() throws Exception {
		Query q = entityManager.createQuery("select h from Addresstype h");
		List<Addresstype> list=q.getResultList();
		return list;
	}

}
