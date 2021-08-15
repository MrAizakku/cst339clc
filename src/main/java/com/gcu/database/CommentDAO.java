package com.gcu.database;

import com.gcu.models.CommentModel;

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
 * 1. Data Access Object - Consolidate data access for the Comment Entity
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

public class CommentDAO implements IConnectString {

    /**
     *
     * Default Constructor - Contains CRUD database methods for blogs table/objects
     */
    public CommentDAO() {
    }

	public CommentModel fetchComment(Integer Id)
	{
		return (CommentModel) null;
	}

	public List<CommentModel> fetchAllComments()
	{
		List<CommentModel> list = new ArrayList<CommentModel>();
		return list;
	}

	public Boolean updateComment(CommentModel comment)
	{
		return true; // successful update
	}

	public Boolean deleteComment(CommentModel comment)
	{
		return true; // successful delete
	}

	public Boolean insertComment(CommentModel comment)
	{
		return true; // successful insert
	}

}
