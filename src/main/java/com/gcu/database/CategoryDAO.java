package com.gcu.database;

import com.gcu.models.CategoryModel;

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
 * 1. Data Access Object - Consolidate data access for the Category Entity
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

public class CategoryDAO implements IConnectString {

    /**
     *
     * Default Constructor - Contains CRUD database methods for blogs table/objects
     */
    public CategoryDAO() {
    }

	public CategoryModel fetchCategory(Integer Id)
	{
		return (CategoryModel) null;
	}

	public List<CategoryModel> fetchAllCategories()
	{
		List<CategoryModel> list = new ArrayList<CategoryModel>();
		return list;
	}

	public Boolean updateCategory(CategoryModel category)
	{
		return true; // successful update
	}

	public Boolean deleteCategory(CategoryModel category)
	{
		return true; // successful delete
	}

	public Boolean insertCategory(CategoryModel category)
	{
		return true; // successful insert
	}

}
