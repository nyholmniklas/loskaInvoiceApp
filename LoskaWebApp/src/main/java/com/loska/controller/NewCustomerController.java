package com.loska.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.loska.dao.CustomerDAO;
import com.loska.dao.UserDAO;
import com.loska.model.Customer;
import com.loska.model.User;
import com.loska.util.CustomerFormBackingBean;
import com.loska.util.CustomerFormConverter;
import com.loska.util.UserSession;

@Controller
@RequestMapping(value="/newCustomer")
public class NewCustomerController {
	@Autowired
	private UserSession userSession;
	@Autowired
	private Validator validator;
	@Autowired
	private CustomerDAO customerDAO;
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getNewCustomerForm(ModelMap model) {
		return new ModelAndView("newCustomer", "customerForm", new CustomerFormBackingBean());
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String createNewCustomer(@Valid @ModelAttribute("customerForm") CustomerFormBackingBean customerForm,
			BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "newCustomer";
		}
		
		int userId = userSession.getUserId();
		User user = userDAO.findByUserId(userId);
		
		CustomerFormConverter converter = new CustomerFormConverter();
		Customer customer = converter.convertFormToCustomer(customerForm, user);
		customerDAO.insertCustomer(customer);
		return "redirect:customers";
	}
}
