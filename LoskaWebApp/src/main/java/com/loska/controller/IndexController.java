package com.loska.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	@RequestMapping(value="/index", method = RequestMethod.POST)
	public String loginSuccess(ModelMap model, Principal principal) {
		return "index";
	}
	
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String index(ModelMap model, Principal principal) {
		return "index";
	}
}
