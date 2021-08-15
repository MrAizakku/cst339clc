package com.gcu.database;

import com.gcu.models.PostModel;

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
 * 1. Data Access Object - Consolidate data access for the Post Entity
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

public class PostDAO implements IConnectString {

    /**
     *
     * Default Constructor - Contains CRUD database methods for blogs table/objects
     */

    public PostDAO() {
    }

	public Double calculateRatingPercentage(Integer id)
	{
		return 5.0D; // Everyone rated this a 5-star :)
	}

	public PostModel fetchPost(Integer id)
	{
		return (PostModel) null;
	}

	public List<PostModel> fetchAllPosts()
	{
		List<PostModel> list = new ArrayList<PostModel>();
		return list;
	}

	public Boolean updatePost(PostModel post)
	{
		return true; // successful update
	}

	public Boolean deletePost(PostModel post)
	{
		return true; // successful delete
	}

	public Boolean insertPost(PostModel post)
	{
		return true; // successful insert
	}

}
