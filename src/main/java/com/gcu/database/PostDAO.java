package com.gcu.database;

import com.gcu.data.DataAccessInterface;
import com.gcu.data.DataAccessPostExtrasInterface;
import com.gcu.models.PostModel;

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
 * 1. Data Access Object - Consolidate data access for the Post Entity
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
public class PostDAO implements DataAccessInterface<PostModel>, DataAccessPostExtrasInterface<PostModel>
{
	@Autowired
	private DataSource datasource;
	private JdbcTemplate jdbcTemplate;
	private RatingDAO DAO_Rating;
	private CommentDAO DAO_Comment;
	private CategoryDAO DAO_Category;
	private UserDAO DAO_User;
    
	public PostDAO(DataSource dataSource)
	{
		this.datasource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public Double calculateRatingPercentage(Integer id)
	{
		return 5.0D; // Everyone rated this a 5-star :)
	}

	@Override
	public List<PostModel> findAll()
	{
		// PostModel(int iD, String title, String content, CategoryModel category, Date date, UserModel author, Date updatedDate,
		// UserModel updatedBy, List<RatingModel> ratingScore, String keywords, List<CommentModel> comments)
		String sql = "SELECT * FROM POSTS";
		List<PostModel> posts = new ArrayList<PostModel>();
		try
		{
			SqlRowSet srs = jdbcTemplate.queryForRowSet(sql);
			while(srs.next())
			{
				posts.add(new PostModel(srs.getInt("POST_ID"),
										srs.getString("POST_TITLE"),
										srs.getString("POST_CONTENT"),
										DAO_Category.findById( srs.getInt("CATEGORY_ID") ),
										srs.getDate("POST_DATE"),
										DAO_User.findById( srs.getInt("POST_AUTHOR") ),
										srs.getDate("POST_UPDATED_DATE"),
										DAO_User.findById( srs.getInt("POST_UPDATED_BY") ),
										
										DAO_Rating.findListByPostID( srs.getInt("POST_ID") ),
										
										srs.getString("POST_KEYWORDS"),

										DAO_Comment.findListByPostID( srs.getInt("POST_ID") )
							));		
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return posts;
	}

	@Override
	public PostModel findById(int id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(PostModel t)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(PostModel t)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(PostModel t)
	{
		// TODO Auto-generated method stub
		return false;
	}
}
