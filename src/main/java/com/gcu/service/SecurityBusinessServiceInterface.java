package com.gcu.service;

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
 * 1. Interface - Security Business Service 
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

public interface SecurityBusinessServiceInterface {
	
	/**
	 * Method to authenticate user 
	 * @param username - user name (email address)
	 * @param password - user password
	 * @return boolean - true is authenticated, false otherwise
	 */
	public boolean authenticate(String username, String password);
	
	/**
	 * Method to determine if user input information is valid
	 * @param username - user name (email) to check (not empty)
	 * @param password - user password to check (not empty)
	 * @return boolean - true if valid user, false otherwise 
	 */
	public boolean inputsValid(String username, String password);
	
	/**
	 * Method to find user by email address
	 * @param email - user email address
	 * @return UserModel - contains user information
	 */
	public UserModel findByEmail(String email);
	
	/**
	 * Method to initiate bean instance
	 */
	public void init();
	
	/**
	 * Method to destroy bean instance
	 */
	public void destroy();
}

