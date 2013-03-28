package com.loska.model.user;

public interface UserDAO {
	public void insert(User user);
	public User findByUserId(int userId);
}
