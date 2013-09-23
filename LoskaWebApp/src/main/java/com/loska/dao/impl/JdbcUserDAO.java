package com.loska.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.loska.dao.UserDAO;
import com.loska.model.User;



public class JdbcUserDAO implements UserDAO{

	private DataSource dataSource;
	
	@Override
	public void insert(User user) {
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
		String sql = "SELECT user_id, username, enabled FROM users WHERE user_id='"+ userId +"'";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			User user = new User();
			if(rs.next()) {
				user.setUserId(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				user.setEnabled(rs.getBoolean("enabled"));
				return user;
			}
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
		return null;
	}
	
	@Override
	public User findByUsername(String username) {
		String sql = "SELECT user_id, username, enabled FROM users WHERE username='"+ username +"'";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			User user = new User();
			if(rs.next()) {
				user.setUserId(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				user.setEnabled(rs.getBoolean("enabled"));
				return user;
			}
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
		return null;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
