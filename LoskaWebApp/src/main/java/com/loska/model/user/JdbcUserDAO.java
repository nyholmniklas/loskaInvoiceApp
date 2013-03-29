package com.loska.model.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			System.out.println(rs.toString());
			int id = 0;
			if(rs.next()) {
				id = rs.getInt(1);
			}
			user.setUserId(id);
			insertUserRole(conn, user);
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
	
	//Set auth ROLE_USER for user
	private void insertUserRole(Connection conn, User user) throws SQLException{
		String sql = "INSERT INTO user_roles (user_id, authority) " +
				"VALUES (" + user.getUser_Id() + ", 'ROLE_USER');";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.executeUpdate();
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
