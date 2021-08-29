package com.gcu.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.DataAccessInterface;
import com.gcu.data.UserDataService;
import com.gcu.models.PostModel;
import com.gcu.models.UserModel;

public class DataAccessService implements DataAccessServiceInterface {
	
	@Autowired
	UserDataService userDAO;
	
	@Autowired
	DataAccessInterface<PostModel> postDAO;
	
	public boolean storeUserInDB(UserModel user) {
		boolean success = userDAO.create(user);
		if(success) {
			System.out.println("User Created Success");
		} else {
			System.out.println("User Created Failure");
		}
		return success;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub	
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub	
	}

	@Override
	public boolean doPost(PostModel post) {
		return postDAO.create(post);
	}
}
