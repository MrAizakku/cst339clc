package com.gcu.database;

import com.gcu.data.DataAccessInterface;
import com.gcu.data.DataAccessUserExtrasInterface;
import com.gcu.models.UserModel;
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
 * 1. Data Access Object - Consolidate data access for the User Entity
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
public class UserDAO implements DataAccessInterface<UserModel>, DataAccessUserExtrasInterface<UserModel>
{
	@Autowired
	private DataSource datasource;
	private JdbcTemplate jdbcTemplate;
	
	public UserDAO(DataSource dataSource)
	{
		this.datasource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public List<UserModel> findAll()
	{
		String sql = "SELECT * FROM USERS";
		List<UserModel> users = new ArrayList<UserModel>();
		try
		{
			SqlRowSet srs = jdbcTemplate.queryForRowSet(sql);
			while(srs.next())
			{
				users.add(new UserModel(srs.getInt("USER_ID"),
										 srs.getString("USER_FIRST_NAME"),
										 srs.getString("USER_LAST_NAME"),
										 srs.getString("USER_EMAIL"),
										 srs.getString("USER_MOBILE"),
										 srs.getString("USER_PASSWORD"),
										 srs.getString("USER_BIRTHDATE"),
										 srs.getBoolean("USER_GENDER"),
										 srs.getInt("USER_ROLE_ID")));		
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return users;
	}

	@SuppressWarnings("deprecation")
	@Override
	public UserModel findById(int id)
	{
		String sql = "SELECT * FROM USERS WHERE USER_ID = ?";
		UserModel user = new UserModel();
		try
		{
			user = jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
				    new UserModel(rs.getInt("USER_ID"),
								  rs.getString("USER_FIRST_NAME"),
								  rs.getString("USER_LAST_NAME"),
								  rs.getString("USER_EMAIL"),
								  rs.getString("USER_MOBILE"),
								  rs.getString("USER_PASSWORD"),
								  rs.getString("USER_BIRTHDATE"),
								  rs.getBoolean("USER_GENDER"),
								  rs.getInt("USER_ROLE_ID")));		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean create(UserModel t)
	{
		String sql = "INSERT INTO USERS(USER_ID, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_MOBILE, USER_PASSWORD, USER_BIRTHDATE, USER_GENDER, USER_ROLE_ID) " +
					 " VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?)";
		try
		{
			int rows = jdbcTemplate.update(sql,
										   t.getFirstName(),
										   t.getLastName(),
										   t.getEmail(),
										   t.getMobile(),
										   t.getPassword(),
										   t.getBirthdate(),
										   t.getGender(),
										   t.getRole());
			return rows == 1 ? true : false;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(UserModel t)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(UserModel t)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Boolean verifyUser(String email, String password)
	{
		int results = 0;
		
		String sql = "SELECT COUNT(*) FROM USERS WHERE USER_EMAIL = ? AND USER_PASSWORD = ?";
		try
		{
			results = jdbcTemplate.queryForObject(sql, new Object[]{email, password}, Integer.class);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		if (results == 0)
		{
			System.out.printf("User does not have an account: Email=%s, Password=%s\n", email, password);
			return false;
		}
		else
		{
			System.out.printf("User has a valid account: Email=%s, Password=%s\n", email, password);
			return true;			
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public Boolean isUserAdmin(UserModel user)
	{
		int results = -1;
		
		// Make assumption - if user id is zero, check database on email/password
		// Otherwise, assume model is populated and only check user role in model
		// Admin = 0, User = 1
		if (user.getUserID() > 0)
		{
			return (user.getRole() == 0);
		}
		
		String sql = "SELECT USER_ROLE_ID FROM USERS WHERE USER_EMAIL = ? AND USER_PASSWORD = ?";
		try
		{
			results = jdbcTemplate.queryForObject(sql, new Object[]{user.getEmail(), user.getPassword()}, Integer.class);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		if (results == 0)
		{
			System.out.printf("User is an administrator: Email=%s, Password=%s\n",user.getEmail(), user.getPassword());
			return true;
		}
		else
		{
			System.out.printf("User is not an administrator: Email=%s, Password=%s\n",user.getEmail(), user.getPassword());
			return false;
			
		}
	}

}
