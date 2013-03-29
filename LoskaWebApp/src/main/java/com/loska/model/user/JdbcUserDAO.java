package com.loska.model.user;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class JdbcUserDAO implements UserDAO{

	private DataSource dataSource;
	
	@Override
	public void insert(User user) {
		//TODO give user ROLE_USER and somehow update user object in this context(id doesnt update)
		String sql = "INSERT INTO users (username, password, enabled)"
				+ "VALUES (?, ?, '1');";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			java.sql.PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.executeUpdate();
			System.out.println("User_id is " + user.getUserId());
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
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
