package com.gcu.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.database.UserDAO;
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
 * 1. Service - Security Business 
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

public class SecurityBusinessService implements SecurityBusinessServiceInterface {

	@Autowired
	private UserDAO userDAO;
	
	public boolean inputsValid(String username, String password) {
		if (!username.trim().isEmpty() && !password.trim().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean authenticate(String username, String password) {
		return userDAO.verifyUser(username, password);
	}

	@Override
	public void init() {
		System.out.println("SBS Init");
	}

	@Override
	public void destroy() {
		System.out.println("SBS Destroy");
	}

	@Override
	public UserModel findByEmail(String email) {
		return userDAO.findByEmail(email);
	}

}
