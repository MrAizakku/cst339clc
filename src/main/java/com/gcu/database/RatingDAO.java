package com.gcu.database;

import com.gcu.data.DataAccessFindListByPostIDInterface;
import com.gcu.data.DataAccessInterface;
import com.gcu.models.RatingModel;

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
 * 1. Data Access Object - Consolidate data access for the Rating Entity
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
public class RatingDAO implements DataAccessInterface<RatingModel>, DataAccessFindListByPostIDInterface<RatingModel>
{
	@Autowired
	private DataSource datasource;
	private JdbcTemplate jdbcTemplate;
	private UserDAO DAO_User;


	public RatingDAO(DataSource dataSource)
	{
		this.datasource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public List<RatingModel> findAll()
	{
		//RatingModel(int ratingID, int ratingPostID, UserModel ratedBy, boolean ratingValue) 
		
		String sql = "SELECT * FROM RATINGS";
		List<RatingModel> ratings = new ArrayList<RatingModel>();
		try
		{
			SqlRowSet srs = jdbcTemplate.queryForRowSet(sql);
			while(srs.next())
			{
				ratings.add(new RatingModel(srs.getInt("RATING_ID"),
											srs.getInt("POST_ID"),
											DAO_User.findById( srs.getInt("RATED_BY") ),
											srs.getBoolean("RATING_VALUE")
							));		
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return ratings;
	}

	@Override
	public RatingModel findById(int id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(RatingModel t)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(RatingModel t)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(RatingModel t)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<RatingModel> findListByPostID(int id) {
		List<RatingModel> list = new ArrayList<RatingModel>();
		return list;
	}

}
