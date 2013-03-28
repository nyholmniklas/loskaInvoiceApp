package com.loska.model.user;

import javax.sql.DataSource;

public class JdbcUserDAO implements UserDAO{

	private DataSource dataSource;
	
	@Override
	public void insert(User user) {
		System.out.println("inserting USER!!!!");
		
	}

	@Override
	public User findByUserId(int userId) {
		System.out.println("findingUser");
		return null;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
