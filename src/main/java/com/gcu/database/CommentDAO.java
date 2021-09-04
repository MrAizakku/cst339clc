package com.gcu.database;

import com.gcu.data.DataAccessFindListByPostIDInterface;
import com.gcu.data.DataAccessInterface;

import com.gcu.models.CommentModel;

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
 * 1. Data Access Object - Consolidate data access for the Comment Entity
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
public class CommentDAO implements DataAccessInterface<CommentModel>, DataAccessFindListByPostIDInterface<CommentModel>
{
	@Autowired
	private DataSource datasource;
	private JdbcTemplate jdbcTemplate;
	private UserDAO DAO_User;


	public CommentDAO(DataSource dataSource)
	{
		this.datasource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public List<CommentModel> findAll()
	{
		// CommentModel(int commentID, int commentPostID, UserModel commentBy, Date commentDate, String commentText)
		
		String sql = "SELECT * FROM COMMENTS";
		List<CommentModel> comments = new ArrayList<CommentModel>();
		try
		{
			SqlRowSet srs = jdbcTemplate.queryForRowSet(sql);
			while(srs.next())
			{
				comments.add(new CommentModel(srs.getInt("COMMENT_ID"),
											  srs.getInt("POST_ID"),
											  DAO_User.findById( srs.getInt("COMMENT_BY") ),
											  srs.getDate("COMMENT_DATE"),
											  srs.getString("COMMENT_TEXT") ));		
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return comments;
	}

	@SuppressWarnings("deprecation")
	@Override
	public CommentModel findById(int id)
	{
		String sql = "SELECT * FROM RATINGS WHERE RATING_ID = ?";
		CommentModel comment = null;
		try
		{
			comment = jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
			new CommentModel(rs.getInt("COMMENT_ID"),
					rs.getInt("POST_ID"),
					DAO_User.findById( rs.getInt("COMMENT_BY") ),
					rs.getDate("COMMENT_DATE"),
					rs.getString("COMMENT_TEXT")
					));		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return comment;
	}

	@Override
	public boolean create(CommentModel t)
	{
		String sql = "INSERT INTO COMMENTS (COMMENT_ID, POST_ID, COMMENT_TEXT, COMMENT_DATE, COMMENT_BY, COMMENT_DELETED_FLAG) VALUES (null,?,?,?,?,?)";
		try
		{
			int rows = jdbcTemplate.update(sql,
											t.getCommentPostID(),
											t.getCommentText(),
											t.getCommentDate(),
											t.getCommentBy().getUserID(),
											"N");
			return rows == 1 ? true : false;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false; // Error occurred - return false
	}

	@Override
	public boolean update(CommentModel t)
	{
		return true;
	}

	@Override
	public boolean delete(String id)
	{
		return true;
	}

	@Override
	public List<CommentModel> findListByPostID(int id)
	{
		String sql = "SELECT * FROM COMMENTS WHERE POST_ID = ?";		

		try
		{
			return jdbcTemplate.query(sql,
					(rs, rowNum) -> new CommentModel(
							rs.getInt("COMMENT_ID"),
							rs.getInt("POST_ID"),
							DAO_User.findById( rs.getInt("COMMENT_BY") ),
							rs.getDate("COMMENT_DATE"),
							rs.getString("COMMENT_TEXT")),
					new Object[]{id});
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
