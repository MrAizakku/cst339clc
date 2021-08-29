package com.gcu.database;

import com.gcu.data.DataAccessInterface;
import com.gcu.data.DataAccessPostExtrasInterface;
import com.gcu.data.DataAccessUserExtrasInterface;
import com.gcu.models.CategoryModel;
import com.gcu.models.PostModel;
import com.gcu.models.UserModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
	
	@Autowired
	private DataAccessInterface<CategoryModel> DAO_Category;

	@Autowired
	private DataAccessInterface<UserModel> DAO_User;

	@Autowired
	private DataAccessUserExtrasInterface<UserModel> DAO_UserExtra;
    
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
	public List<PostModel> findAll() {
		System.out.println("inside postDAO find all.");
		String sql = "SELECT * FROM POSTS";
		List<PostModel> posts = new ArrayList<PostModel>();
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
		
		try {
			SqlRowSet srs = jdbcTemplate.queryForRowSet(sql);
			while(srs.next()) {
				//System.out.println(srs.getObject("POST_DATE").toString() + "!   --  " + format.parse(srs.getObject("POST_DATE").toString()) );
				posts.add(new PostModel(
						srs.getInt("POST_ID"),
						srs.getString("POST_TITLE"),
						srs.getString("POST_CONTENT"),
						DAO_Category.findById( srs.getInt("CATEGORY_ID") ),
						format.parse(srs.getObject("POST_DATE").toString()),
						srs.getInt("POST_AUTHOR"),
						DAO_UserExtra.findNameById( srs.getInt("POST_AUTHOR") ),
						format.parse(srs.getObject("POST_UPDATED_DATE").toString()),
						srs.getInt("POST_UPDATED_BY"),
						//DAO_Rating.findListByPostID( srs.getInt("POST_ID") ),
						null,
						srs.getString("POST_KEYWORDS"),
						//DAO_Comment.findListByPostID( srs.getInt("POST_ID") )
						null));	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("findAll complete.");
		return posts;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public PostModel findById(int id)
	{
		System.out.println("inside postDAO findById.");
		String sql = "SELECT * FROM POSTS WHERE POST_ID = ?";
		PostModel post = null;
		try
		{
			post = jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
				    new PostModel(rs.getInt("POST_ID"),
							rs.getString("POST_TITLE"),
							rs.getString("POST_CONTENT"),
							DAO_Category.findById( rs.getInt("CATEGORY_ID") ),
							rs.getDate("POST_DATE"),
							rs.getInt("POST_AUTHOR"),
							DAO_UserExtra.findNameById( rs.getInt("POST_AUTHOR") ),
							rs.getDate("POST_UPDATED_DATE"),
							rs.getInt("POST_UPDATED_BY"),
							//DAO_Rating.findListByPostID( srs.getInt("POST_ID") ),
							null,
							rs.getString("POST_KEYWORDS"),

							//DAO_Comment.findListByPostID( srs.getInt("POST_ID") )
							null));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return post;
	}

	@Override
	public boolean create(PostModel t)
	{
		String sql = "INSERT INTO POSTS(POST_ID, POST_TITLE, CATEGORY_ID, POST_CONTENT, POST_DATE, POST_AUTHOR, POST_UPDATED_DATE, POST_UPDATED_BY, POST_DELETED_FLAG, POST_KEYWORDS, POST_PRIVATE_FLAG) VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			int rows = jdbcTemplate.update(sql,
										   t.getTitle(),
										   t.getCategory().getID(),
										   t.getContent(),
										   t.getDate(),
										   t.getAuthorID(),
										   t.getUpdatedDate(),
										   t.getUpdatedBy(),
										   "N",
										   t.getKeywords(),
										   "N");
			return rows == 1 ? true : false;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
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
