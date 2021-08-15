package com.gcu.database;

import com.gcu.models.RatingModel;

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
 * 1. Data Access Object - Consolidate data access for the Rating Entity
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

public class RatingDAO implements IConnectString {

    /**
     *
     * Default Constructor - Contains CRUD database methods for blogs table/objects
     */

    public RatingDAO() {
    }

	public RatingModel fetchRating(Integer Id)
	{
		return (RatingModel) null;
	}

	public List<RatingModel> fetchAllRatings()
	{
		List<RatingModel> list = new ArrayList<RatingModel>();
		return list;
	}

	public Boolean updateRating(RatingModel rating)
	{
		return true; // successful update
	}

	public Boolean deleteRating(RatingModel rating)
	{
		return true; // successful delete
	}

	public Boolean insertRating(RatingModel rating)
	{
		return true; // successful insert
	}

}
