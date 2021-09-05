package com.gcu.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.models.CategoryModel;
import com.gcu.models.CommentModel;
import com.gcu.models.PostModel;
import com.gcu.models.UserModel;

public class BusinessService implements BusinessServiceInterface {
	
	@Autowired
	private DataAccessServiceInterface DAO;

	@Autowired
	private SecurityBusinessServiceInterface security;
	
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

	@Override
	public boolean inputsValid(String email, String password) {
		return security.inputsValid(email, password);
	}

	@Override
	public boolean authenticate(String email, String password) {
		return security.authenticate(email, password);
	}

	@Override
	public @Valid UserModel findByEmail(String email) {
		return security.findByEmail(email);
	}

	@Override
	public List<PostModel> getMyPosts(int id) {
		return DAO.getMyPosts(id);
	}

	@Override
	public boolean deletePostById(String id) {
		return DAO.deletePostById(id);
		
	}

	@Override
	public boolean updatePost(PostModel post) {
		return DAO.updatePost(post);
	}

	@Override
	public boolean storeCommentInDB(CommentModel comment) {
		return DAO.storeCommentInDB(comment);
	}
}
