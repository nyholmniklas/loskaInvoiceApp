package com.loska.dao;

import org.springframework.stereotype.Component;

import com.loska.model.User;

@Component
public interface UserDAO {
	public void insert(User user);
	public User findByUserId(int userId);
	public User findByUsername(String username);
}
