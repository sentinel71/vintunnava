package com.portal.service;

import javax.servlet.http.HttpServletRequest;

import com.portal.model.User;

public interface UserService {
	
	public User createUser(String email, String password) throws Exception;

	public User getUserById(String uid) throws Exception;

	public User updateUser(User user) throws Exception;

	public int validateLogin(HttpServletRequest request, String email, String password) throws Exception;
}
