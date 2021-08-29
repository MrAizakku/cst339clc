package com.gcu.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.gcu.data.DataAccessInterface;
import com.gcu.models.CategoryModel;
import com.gcu.models.PostModel;
import com.gcu.models.UserModel;

public class DataAccessService implements DataAccessServiceInterface {
	
	@Autowired
	DataAccessInterface<UserModel> userDAO;

	@Autowired
	DataAccessInterface<PostModel> postDAO;

	@Autowired
	DataAccessInterface<CategoryModel> categoryDAO;
	
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

	@Override
	public List<PostModel> getPosts() {
		return postDAO.findAll();
	}

	@Override
	public PostModel findByID(int id) {
		return postDAO.findById(id);
	}

	@Override
	public List<CategoryModel> loadCategories() {
		return categoryDAO.findAll();
	}
}
