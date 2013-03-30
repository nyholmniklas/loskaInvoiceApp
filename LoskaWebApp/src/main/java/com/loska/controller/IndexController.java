package com.loska.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.loska.dao.UserDAO;
import com.loska.session.UserSession;

@Controller
public class IndexController {
	@Autowired
	private UserSession userSession;
	@Autowired
	private UserDAO userDAO;
//	
//	@RequestMapping(value="/index", method = RequestMethod.POST)
//	public String loginSuccess(ModelMap model, Principal principal) {
//
//		return "index";
//	}
	
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String index(ModelMap model, Principal principal) {
		userSession.setUserId(userDAO.findByUsername(principal.getName()));
		return "index";
	}
}
