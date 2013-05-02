package com.loska.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.loska.dao.CustomerDAO;
import com.loska.util.UserSession;

@Controller
@RequestMapping(value="/customers")
public class ListCustomersController {
	@Autowired
	private UserSession userSession;
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getCustomers(ModelMap model, Principal principal) {
		model.addAttribute("customers", customerDAO.findAllCustomersForUserId(userSession.getUserId()));
		return new ModelAndView("customers", model);
	}
}
