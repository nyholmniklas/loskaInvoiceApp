package com.loska.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.loska.dao.InvoiceDAO;
import com.loska.dao.UserDAO;
import com.loska.util.UserSession;

@Controller
@RequestMapping(value="/invoices")
public class ListInvoicesController {
	@Autowired
	private UserSession userSession;
	@Autowired 
	private InvoiceDAO invoiceDAO;
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getInvoices(ModelMap model, Principal principal) {
		model.addAttribute("invoices", invoiceDAO.getAllInvoicesBelongingToUserId(userSession.getUserId()));
		return new ModelAndView("invoices", model);
	}
}
