package com.gcu.database;

import com.gcu.data.DataAccessInterface;
import com.gcu.models.CategoryModel;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

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
 * 08/28/21 K. Lamb             Rework to use JdbcTemplate
 *
 *
 */

@Service
public class CategoryDAO implements DataAccessInterface<CategoryModel>
{
	@Autowired
	private DataSource datasource;
	private JdbcTemplate jdbcTemplate;

	public CategoryDAO(DataSource dataSource)
	{
		this.datasource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public List<CategoryModel> findAll()
	{
		// CategoryModel(int iD, String categoryName)
		
		String sql = "SELECT * FROM CATEGORIES";
		List<CategoryModel> categories = new ArrayList<CategoryModel>();
		try
		{
			SqlRowSet srs = jdbcTemplate.queryForRowSet(sql);
			while(srs.next())
			{
				categories.add(new CategoryModel(srs.getInt("CATEGORY_ID"),
												 srs.getString("CATEGORY_NAME")	));		
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return categories;
	}

	@SuppressWarnings("deprecation")
	@Override
	public CategoryModel findById(int id)
	{
		String sql = "SELECT * FROM CATEGORIES WHERE CATEGORY_ID = ?";
		CategoryModel category = null;
		try
		{
			category = jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
				    new CategoryModel(rs.getInt("CATEGORY_ID"),
							 		  rs.getString("CATEGORY_NAME")
							 		  ));		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return category;
	}

	@Override
	public boolean create(CategoryModel t)
	{
		String sql = "INSERT INTO CATEGORIES (CATEGORY_ID, CATEGORY_NAME) VALUES (null, ?)";
		try
		{
			int rows = jdbcTemplate.update(sql, t.getCategoryName());
			return rows == 1 ? true : false;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false; // Error occurred - return false
	}

	@Override
	public boolean update(CategoryModel t)
	{
		return false; // not implemented
	}

	@Override
	public boolean delete(CategoryModel t)
	{
		return false; // not implemented
	}

}
