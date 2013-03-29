package com.loska.model.user;

import org.springframework.stereotype.Component;

@Component
public interface UserDAO {
	public void insert(User user);
	public User findByUserId(int userId);
}
