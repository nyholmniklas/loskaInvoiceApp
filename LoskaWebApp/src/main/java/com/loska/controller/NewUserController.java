package com.loska.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.loska.dao.UserDAO;
import com.loska.model.user.User;

@Controller
public class NewUserController {
	
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private Validator validator;

	@RequestMapping(value="/newUser", method=RequestMethod.GET)
	public ModelAndView createNewUser(ModelMap model){
		return new ModelAndView("newUser", "user", new User());
	}
	
	@RequestMapping(value="/newUser", method=RequestMethod.POST)
	public String createNewUser(@Valid User user, BindingResult result,
			ModelMap model){
//		validator.validate(user, result);
		if (result.hasErrors()) {
			return "newUser";
		}
		else {
			userDAO.insert(user);
		}
		return new String("login");
	}
	
}
