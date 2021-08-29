package com.gcu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.models.CategoryModel;
import com.gcu.models.PostModel;
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

	@Override
	public boolean doPost(PostModel post) {
		return DAO.doPost(post);
	}

	@Override
	public List<PostModel> getPosts() {
		return DAO.getPosts();
	}

	@Override
	public PostModel findByID(int id) {
		return DAO.findByID(id);
	}

	@Override
	public List<CategoryModel> loadCategories() {
		return DAO.loadCategories();
	}

}
