package com.portal.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.portal.dao.AddressDao;
import com.portal.model.Address;

public class AddressDaoImpl implements AddressDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Transactional
	public Address insertAddress(Address addr) throws Exception {
		entityManager.persist(addr);
		entityManager.flush();
		return addr;
	}

	@Transactional
	public Address updateAddress(Address addr) throws Exception {
		return entityManager.merge(addr);
	}

}
