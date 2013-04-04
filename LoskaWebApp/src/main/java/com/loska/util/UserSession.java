package com.loska.util;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.loska.model.User;

@Component
@Scope(value="session")
public class UserSession{
	private int userId;
	public UserSession(){
		userId = 6;
	}

	public void setUserId(User user) {
		setUserId(user.getUser_Id());
		
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
