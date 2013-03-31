package com.loska.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public ModelAndView getCreateUserForm(ModelMap model){
		return new ModelAndView("newUser", "user", new User());
	}
	
	@RequestMapping(value="/newUser", method=RequestMethod.POST)
	public String createNewUser(@Valid @ModelAttribute User user, BindingResult result,
			ModelMap model){
//		validator.validate(user, result);
		
		//check if username is taken
		if (userDAO.findByUsername(user.getUsername()) != null) {
			result.rejectValue("username", "UserNameTaken", "Käyttäjätunnus on jo olemassa.");
			return "newUser";
		}
		
		//else check for validation errors
		if (result.hasErrors()) {
			return "newUser";
		}
		else {
			userDAO.insert(user);
		}
		return "login";
	}
	
}
