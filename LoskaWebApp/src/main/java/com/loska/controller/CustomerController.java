package com.loska.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.loska.dao.CustomerDAO;
import com.loska.dao.InvoiceDAO;
import com.loska.dao.UserDAO;
import com.loska.model.Address;
import com.loska.model.Customer;
import com.loska.model.User;
import com.loska.util.CustomerFormBackingBean;
import com.loska.util.CustomerFormConverter;
import com.loska.util.UserSession;

@Controller
public class CustomerController {
	@Autowired
	private UserSession userSession;
	@Autowired
	private InvoiceDAO invoiceDAO;
	@Autowired
	private CustomerDAO customerDAO;
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value="/editCustomer", method=RequestMethod.GET)
	public ModelAndView editCustomer(@RequestParam Integer customer_id, ModelMap model){
		//TODO CHECK IF CUSTOMER'S USERID MATCHES SESSION USER ID!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		Customer customer = customerDAO.findCustomerById(customer_id);
		
		CustomerFormBackingBean form = new CustomerFormBackingBean();
		//Set name and ytunnus
		form.setName(customer.getName());
		form.setY_tunnus(customer.getY_tunnus());
		
		//Set address info
		Address bill_to = customer.getBill_to();
		Address ship_to = customer.getShip_to();
		
		form.setCustomer_id(customer.getCustomer_id().toString());
		
		form.setBill_to_name(bill_to.getName());
		form.setBill_to_name2(bill_to.getName2());
		form.setBill_to_address(bill_to.getAddress());
		form.setBill_to_postcode(bill_to.getPostcode());
		form.setBill_to_city(bill_to.getCity());
		form.setBill_to_country(bill_to.getCountry());
		form.setShip_to_name(ship_to.getName());
		form.setShip_to_name2(ship_to.getName2());
		form.setShip_to_address(ship_to.getAddress());
		form.setShip_to_postcode(ship_to.getPostcode());
		form.setShip_to_city(ship_to.getCity());
		form.setShip_to_country(ship_to.getCountry());
		
//		List<Invoice> invoices = invoiceDAO.findInvoiceByCustomerId(customer.getCustomer_id());
		model.addAttribute("customerForm", form);
		ModelAndView mav = new ModelAndView("/editCustomer");
		mav.addAllObjects(model);
		return mav;
	}
	
	@RequestMapping(value="/editCustomer", method=RequestMethod.POST)
	public String updateCustomer(@Valid @ModelAttribute CustomerFormBackingBean form,
			BindingResult result, ModelMap model){
		//TODO CHECK IF CUSTOMER'S USERID MATCHES SESSION USER ID!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		int userId = userSession.getUserId();
		User user = userDAO.findByUserId(userId);
		CustomerFormConverter converter = new CustomerFormConverter();
		Customer customer = converter.convertFormToCustomer(form, user);
		customer.setCustomer_id(Integer.parseInt(form.getCustomer_id()));
		customerDAO.updateCustomer(customer);
		return "redirect:index";
	}
}
