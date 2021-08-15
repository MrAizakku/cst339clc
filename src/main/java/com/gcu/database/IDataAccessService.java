package com.gcu.database;

import com.gcu.models.CategoryModel;
import com.gcu.models.CommentModel;
import com.gcu.models.PostModel;
import com.gcu.models.RatingModel;
import com.gcu.models.UserModel;

import java.util.ArrayList;
import java.util.List;

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
 * 1. Interface to consolidate all Database Access Objects (DAO)
 * 2.
 * 3.
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 08/14/21 K. Lamb             Initial Creation
 *
 *
 */

public interface IDataAccessService {


	//
	// Category Methods
	//
	public CategoryModel fetchCategory(Integer Id);

	public List<CategoryModel> fetchAllCategories();

	public Boolean updateCategory(CategoryModel category);

	public Boolean deleteCategory(CategoryModel category);

	public Boolean insertCategory(CategoryModel category);


	//
	// Comment Methods
	//

	public CommentModel fetchComment(Integer Id);

	public List<CommentModel> fetchAllComments();

	public Boolean updateComment(CommentModel comment);

	public Boolean deleteComment(CommentModel comment);

	public Boolean insertComment(CommentModel comment);


	//
	// Post Methods
	//

	public Double calculateRatingPercentage(Integer id);

	public PostModel fetchPost(Integer id);

	public List<PostModel> fetchAllPosts();

	public Boolean updatePost(PostModel post);

	public Boolean deletePost(PostModel post);

	public Boolean insertPost(PostModel post);


	//
	// Rating Methods
	//

	public RatingModel fetchRating(Integer Id);

	public List<RatingModel> fetchAllRatings();

	public Boolean updateRating(RatingModel rating);

	public Boolean deleteRating(RatingModel rating);

	public Boolean insertRating(RatingModel rating);


	//
	// User Methods
	//

	public Boolean verifyUser(String email, String password);

	public Boolean isUserAdmin(UserModel user);

	public UserModel fetchUser(String email, String password);

	public UserModel fetchUser(Integer Id);

	public List<UserModel> fetchAllUsers();

	public Boolean updateUser(UserModel user);

	public Boolean deleteUser(UserModel user);

	public Boolean insertUser(UserModel user);

}

