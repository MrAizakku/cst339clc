package com.gcu.data;

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
 * 1. Interface - Data Access - User Extras
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

public interface DataAccessUserExtrasInterface <T>
{
	/**
	 * Method to verify user is valid (in database) by email/password
	 * @param email - user email
	 * @param password - user password
	 * @return boolean - true on successful verification, false otherwise
	 */
	public Boolean verifyUser(String email, String password);
	
	/**
	 * Method to ascertain if user has administrative rights
	 * @param t - generic (user model)
	 * @return boolean - true is admin, false otherwise
	 */
	public Boolean isUserAdmin(T t);
	
	/**
	 * Method to find user model by email (unique/user id)
	 * @param email - user email address
	 * @return UserModel if exists, null otherwise
	 */
	public UserModel findByEmail(String email);
	
	/**
	 * Return user name(first space last) specified by id
	 * @param id - user id (key)
	 * @return string - concatenated first space last
	 */
	public String findNameById(int id);
}
