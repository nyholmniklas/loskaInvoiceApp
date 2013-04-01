package com.loska.controller;

import java.sql.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.loska.dao.InvoiceDAO;
import com.loska.model.Invoice;
import com.loska.session.UserSession;

@Controller
@RequestMapping(value="/newInvoice")
public class NewInvoiceController {
	@Autowired
	private UserSession userSession;
	@Autowired
	private InvoiceDAO invoiceDAO;
	@Autowired
	private Validator validator;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getNewInvoiceForm(ModelMap model){
		return new ModelAndView("newInvoice", "invoice", new Invoice());
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String createNewInvoice(@Valid @ModelAttribute Invoice invoice, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {
			return "newInvoice";
		}
		else  {
			//set date
			java.util.Calendar cal = java.util.Calendar.getInstance(); 
			java.sql.Date date = new Date(cal.getTimeInMillis());
			invoice.setDate(date);
			invoice.setUser_id(userSession.getUserId());
//			invoice.setDescription(model.)
			invoiceDAO.insert(invoice);
		}
		return "redirect:index";
	}

}
