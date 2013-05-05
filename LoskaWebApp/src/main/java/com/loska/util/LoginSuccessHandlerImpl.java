package com.loska.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.loska.dao.UserDAO;

public class LoginSuccessHandlerImpl extends SavedRequestAwareAuthenticationSuccessHandler{
	@Autowired
	UserSession userSession;
	@Autowired
	UserDAO userDAO;
	
	@Override
	    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
		userSession = new UserSession();
		userSession.setUserId(userDAO.findByUsername(authentication.getName()).getUser_Id());
		response.sendRedirect("index");
//	    super.onAuthenticationSuccess(request, response, authentication);

	   }
}
