package com.loska.model.user;

public class User {
	int user_id;
	String username;
	String password;
	boolean enabled;
	
	public int getUser_Id() {
		return user_id;
	}
	public void setUserId(int userId) {
		this.user_id = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
}
