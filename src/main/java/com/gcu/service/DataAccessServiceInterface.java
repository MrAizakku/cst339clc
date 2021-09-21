package com.gcu.service;

import java.util.List;

import com.gcu.models.CategoryModel;
import com.gcu.models.CommentModel;
import com.gcu.models.PostModel;
import com.gcu.models.UserModel;

/**
 * ---------------------------------------------------------------------------
 * Name      : Group Purple
 * Members   : D. Johnson, I Tucker, I. Debenedetto, K. Kubli, K. Lamb
 * Date      : 2021-08-14
 * Class     : CST-339 Java Programming III
 * Professor : Brandom Bass
 * Assignment: Milestone - CLC Group Assignment
 * Disclaimer: This is our own work
 * ---------------------------------------------------------------------------
 * Description:
 * 1. Interface - Data Access Service 
 * 2.
 * 3.
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 08/14/21 Team                Initial Creation
 *
 *
 */

public interface DataAccessServiceInterface {
	
	/**
	 * Method to store user information in the database
	 * @param user - user information
	 * @return boolean - true if successfully stored, false otherwise
	 */
	public boolean storeUserInDB(UserModel user);
	
	/**
	 * Method to store comment in the database
	 * @param comment - comment information 
	 * @return  boolean - true if successfully stored, false otherwise
	 */
	public boolean storeCommentInDB(CommentModel comment);
	
	/**
	 * Method to initiate bean instance
	 */
	public void init();
	
	/**
	 * Method to destroy bean instance
	 */
	public void destroy();
	
	/**
	 * Method to create a post in the database
	 * @param post - model containing post information
	 * @return boolean - true if successfully stored, false otherwise
	 */
	public boolean doPost(PostModel post);
	
	/**
	 * Method to update a post into the database
	 * @param post - model containing post information
	 * @return boolean - true if successfully stored, false otherwise
	 */
	public boolean updatePost(PostModel post);
	
	/**
	 * Method to retrieve all posts from the database
	 * @return list of PostModel contain posts information
	 */
	public List<PostModel> getPosts();
	
	/**
	 * Method to find specific post by post id
	 * @param id - post id (key)
	 * @return PostModel containing post information
	 */
	public PostModel findByID(int id);
	
	/**
	 * Method to return all categories
	 * @return list of categories
	 */
	public List<CategoryModel> loadCategories();
	
	/**
	 * Method to retrieve all posts by specific user id
	 * @param id - user id
	 * @return list of PostModel
	 */
	public List<PostModel> getMyPosts(int id);
	
	/**
	 * Method to delete post specified by post id
	 * @param id - post id
	 * @return boolean - true if successfully stored, false otherwise
	 */
	public boolean deletePostById(String id);
}
