package com.facade.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.UserDAO;
import com.facade.UserFacade1;
import com.model.User;

@Stateless
public class UserFacadeImp1 implements UserFacade1 {

	@EJB 
	private UserDAO userDAO;
	
	public User findUserByEmail(String email) {
		//return userDAO.findUserByEmail(email);
		
		return null;
	}
}