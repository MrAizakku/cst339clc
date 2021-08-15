package com.gcu.database;

import com.gcu.models.UserModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
 * 1. Data Access Object - Consolidate data access for the User Entity
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

public class UserDAO implements IConnectString {

    /**
     *
     * Default Constructor - Contains CRUD database methods for blogs table/objects
     */
    public UserDAO() {
    }

	public Boolean verifyUser(String email, String password)
	{
		return true; // valid user
	}

	public Boolean isUserAdmin(UserModel user)
	{
		return true; // For now, every user has admin rights :)
	}

	public UserModel fetchUser(String email, String password)
	{
		return (UserModel) null;
	}

	public UserModel fetchUser(Integer Id)
	{
		return (UserModel) null;
	}

	public List<UserModel> fetchAllUsers()
	{
		List<UserModel> list = new ArrayList<UserModel>();
		return list;
	}

	public Boolean updateUser(UserModel user)
	{
		return true; // successful update
	}

	public Boolean deleteUser(UserModel user)
	{
		return true; // successful delete
	}

	public Boolean insertUser(UserModel user)
	{
		return true; // successful insert
	}

}
