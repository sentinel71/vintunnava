package com.portal.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.portal.dao.UserDao;
import com.portal.model.User;

public class UserDaoImpl implements UserDao{
	@PersistenceContext
	private EntityManager entityManager;
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Transactional
	public User createUser(User user)  throws Exception{
		entityManager.persist(user);
		entityManager.flush();
		return user;
	}

	public User getUserById(String uid) throws Exception {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("userid", uid);
		Query q = entityManager.createNamedQuery(User.FIND_USER_BY_ID);
		for(Entry<String, Object> entry:parameters.entrySet())
			q.setParameter(entry.getKey(), entry.getValue());
		//Query q = entityManager.createQuery("select u from User u where u.userId = :"+uid);
		User user = (User) q.getResultList().get(0);
		return user;
	}

	@Transactional
	public User updateUser(User user) throws Exception {
		return entityManager.merge(user);		
	}

	public User getUserByEmail(String email) throws Exception {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("email", email);
		Query q = entityManager.createNamedQuery(User.FIND_USER_BY_EMAIL);
		for(Entry<String, Object> entry:parameters.entrySet())
			q.setParameter(entry.getKey(), entry.getValue());
		List<User> userList = q.getResultList();
		if(userList.isEmpty())
			return null;
		User user = userList.get(0);
		return user;
	}
	
	

}
