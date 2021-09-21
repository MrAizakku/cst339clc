package com.gcu.data;

import java.util.List;

import com.gcu.models.PostModel;

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
 * 1. Interface - Data Access - Post Extras
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

public interface DataAccessPostExtrasInterface <T> {
	
	/**
	 * Method to calculate rating percentage for post specified by id
	 * @param id - post id (key)
	 * @return double - average of ratings
	 */
	public Double calculateRatingPercentage(int id);
	
	/**
	 * Method to find all posts by user id (key)
	 * @param id - user id 
	 * @return list of PostModel holding all posts by specified user
	 */
	public List<PostModel> findAllByUserId(int id);
}
