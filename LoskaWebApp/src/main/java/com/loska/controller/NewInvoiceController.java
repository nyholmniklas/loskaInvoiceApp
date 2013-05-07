package com.loska.controller;

import java.sql.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.AutoPopulatingList;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
import com.loska.model.Invoice;
import com.loska.model.InvoiceRow;
import com.loska.model.User;
import com.loska.util.InvoiceFormBackingBean;
import com.loska.util.InvoiceFormConverter;
import com.loska.util.UserSession;

@Controller
public class NewInvoiceController {
	@Autowired
	private UserSession userSession;
	@Autowired
	private InvoiceDAO invoiceDAO;
	@Autowired
	private CustomerDAO customerDAO;
	@Autowired
	private UserDAO userDAO;

	
    @InitBinder
    public void setDataBinder(WebDataBinder dataBinder) {
        dataBinder.setAutoGrowNestedPaths(false);
    }
	
	@RequestMapping(value="/newInvoice", method=RequestMethod.GET)
	public ModelAndView getNewInvoiceForm(ModelMap model){
		InvoiceFormBackingBean form = new InvoiceFormBackingBean();
		
		InvoiceRow row = new InvoiceRow();
//		row.setName("Nimi");
		row.setAmmount(1);
//		row.setPrice(15f);
//		row.setTax(24f);
		form.getRows().add(row);
		//set date
		java.util.Calendar cal = java.util.Calendar.getInstance(); 
		java.sql.Date date = new Date(cal.getTimeInMillis());
		form.setDate(date);
		form.setDue_date(date);
		
		return new ModelAndView("newInvoice", "invoiceForm", form);
	}
	
	@RequestMapping(value="/newInvoice", method=RequestMethod.POST)
	public ModelAndView createNewInvoice(@Valid @ModelAttribute("invoiceForm") InvoiceFormBackingBean form, BindingResult result,
			ModelMap model) {
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView("newInvoice", "invoiceForm", form);
			return mav;
		}
		else  {

			
			//Get user from session
			int userId = userSession.getUserId();
			User user = userDAO.findByUserId(userId);
			
			InvoiceFormConverter converter = new InvoiceFormConverter();
			Invoice invoice = converter.convertFormToInvoice(form, user);
			invoiceDAO.insert(invoice);
		}
		return new ModelAndView("redirect:index");
	}
	
	@RequestMapping(value="/newInvoiceForCustomer", method=RequestMethod.GET)
	public ModelAndView getNewInvoiceFormForCustomer(@ModelAttribute InvoiceFormBackingBean form, @RequestParam String customer_id, BindingResult result,
			ModelMap model){
		//TODO CHECK IF CUSTOMER'S USERID MATCHES SESSION USER ID!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		Customer customer = customerDAO.findCustomerById(Integer.parseInt(customer_id));
		
		InvoiceRow row = new InvoiceRow();
		row.setAmmount(1);
		form.getRows().add(row);
		
		//set date
		java.util.Calendar cal = java.util.Calendar.getInstance(); 
		java.sql.Date date = new Date(cal.getTimeInMillis());
		form.setDate(date);
		form.setDue_date(date);
		
		Address bill_to = customer.getBill_to();
		Address ship_to = customer.getShip_to();
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
		
		return new ModelAndView("newInvoice", "invoiceForm", form);
	}
}
