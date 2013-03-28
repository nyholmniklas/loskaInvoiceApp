package com.loska.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.loska.model.user.User;
import com.loska.model.user.UserDAO;

@Controller
public class NewUserController {

	@RequestMapping(value="/newUser", method=RequestMethod.GET)
	public ModelAndView createNewUser(ModelMap model){
		return new ModelAndView("newUser", "user", new User());
	}
	
	@RequestMapping(value="/newUser", method=RequestMethod.POST)
	public ModelAndView createNewUser(@ModelAttribute("SpringWeb")User user,
			ModelMap model){
		return new ModelAndView("hello");
	}
	
}
