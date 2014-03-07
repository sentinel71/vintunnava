package com.portal.dao;

import com.portal.model.User;

public interface UserDao {
	public User createUser(User user) throws Exception;

	public User getUserById(String uid) throws Exception;

	public User updateUser(User user) throws Exception;

	public User getUserByEmail(String email) throws Exception;
}
