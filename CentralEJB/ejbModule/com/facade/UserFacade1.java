package com.facade;

import javax.ejb.Local;

import com.model.User;

@Local
public interface UserFacade1 {
	public User findUserByEmail(String email);
}