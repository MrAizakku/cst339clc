package com.gcu.service;

import java.util.List;

import com.gcu.models.CategoryModel;
import com.gcu.models.CommentModel;
import com.gcu.models.PostModel;
import com.gcu.models.UserModel;

public interface DataAccessServiceInterface {
	public boolean storeUserInDB(UserModel user);
	public boolean storeCommentInDB(CommentModel comment);
	public void init();
	public void destroy();
	public boolean doPost(PostModel post);
	public boolean updatePost(PostModel post);
	public List<PostModel> getPosts();
	public PostModel findByID(int id);
	public List<CategoryModel> loadCategories();
	public List<PostModel> getMyPosts(int id);
	public boolean deletePostById(String id);
}
