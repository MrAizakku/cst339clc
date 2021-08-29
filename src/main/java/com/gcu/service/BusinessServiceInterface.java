package com.gcu.service;

import java.util.List;

import com.gcu.models.CategoryModel;
import com.gcu.models.PostModel;
import com.gcu.models.UserModel;

public interface BusinessServiceInterface {
	public boolean storeUserInDB(UserModel user);
	public boolean doPost(PostModel post);
	public void init();
	public void destroy();
	public List<PostModel> getPosts();
	public PostModel findByID(int id);
	public List<CategoryModel> loadCategories();
}
