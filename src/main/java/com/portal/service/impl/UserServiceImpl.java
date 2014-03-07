package com.portal.service.impl;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.portal.dao.UserDao;
import com.portal.model.User;
import com.portal.service.UserService;
import com.portal.util.VerificationKeyGenerator;

public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	public User createUser(String email, String password)  throws Exception{
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setVerificationKey(VerificationKeyGenerator.generateKey(email + password));		
		return userDao.createUser(user);
	}

	public User getUserById(String uid) throws Exception {		
		return userDao.getUserById(uid);
	}

	public User updateUser(User user) throws Exception {
		user.setUpdatedOn(new Timestamp((new Date()).getTime()));
		return userDao.updateUser(user);		
	}

	public int validateLogin(HttpServletRequest request,String email, String password) throws Exception {
		User user = userDao.getUserByEmail(email);
//		if(user.getVerificationKey().isEmpty() && user.getPassword().contentEquals(password))
//			return true; 
//		return false;
		if(user==null)
			return 0; //email doesn't exists
		if(user.getVerificationKey().isEmpty()){
			if(!user.getPassword().contentEquals(password))
				return 1;//password incorrect			
		}else{
			return 2; //account not activated
		}
		request.getSession().setAttribute("user", user);
		return 3; //correct login credentials
	}

}
