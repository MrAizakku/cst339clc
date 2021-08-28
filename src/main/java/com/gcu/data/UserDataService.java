package com.gcu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gcu.models.UserModel;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserModel findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(UserModel t) {
		// TODO Auto-generated method stub
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
