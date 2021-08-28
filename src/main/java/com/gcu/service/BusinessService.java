package com.gcu.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.models.UserModel;

public class BusinessService implements BusinessServiceInterface {
	
	@Autowired
	private DataAccessServiceInterface DAO;
	
	public boolean storeUserInDB(UserModel user) {
		return DAO.storeUserInDB(user);
	}
	
	@Override
	public void init() {
		System.out.println("BS INIT");
	}

	@Override
	public void destroy() {
		System.out.println("BS DESTROY");
	}

}
