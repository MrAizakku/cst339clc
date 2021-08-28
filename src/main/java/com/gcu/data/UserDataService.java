package com.gcu.data;

import java.util.ArrayList;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.gcu.models.UserModel;

@Service
public class UserDataService implements DataAccessInterface<UserModel> {
	@Autowired
	private DataSource datasource;
	private JdbcTemplate jdbcTemplate;
	
	public UserDataService(DataSource dataSource) {
		this.datasource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public List<UserModel> findAll() {
		String sql = "SELECT * FROM USERS";
		List<UserModel> users = new ArrayList<UserModel>();
		try {
			SqlRowSet srs = jdbcTemplate.queryForRowSet(sql);
			while(srs.next()) {
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
		catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public UserModel findById(int id) {
		String sql = "SELECT * FROM USERS WHERE USER_ID = ?";
		UserModel user = new UserModel();
		try {
			jdbcTemplate.update(sql, id);
			SqlRowSet srs = jdbcTemplate.queryForRowSet(sql);
			while(srs.next()) {
				user = new UserModel(srs.getInt("USER_ID"),
									 srs.getString("USER_FIRST_NAME"),
									 srs.getString("USER_LAST_NAME"),
									 srs.getString("USER_EMAIL"),
									 srs.getString("USER_MOBILE"),
									 srs.getString("USER_PASSWORD"),
									 srs.getString("USER_BIRTHDATE"),
									 srs.getBoolean("USER_GENDER"),
									 srs.getInt("USER_ROLE_ID"));		
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean create(UserModel t) {
		String sql = "INSERT INTO USERS(USER_ID, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_MOBILE, USER_PASSWORD, USER_BIRTHDATE, USER_GENDER, USER_ROLE_ID) VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
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
	public boolean update(UserModel t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(UserModel t) {
		// TODO Auto-generated method stub
		return false;
	}
}
