package com.loska.controller;

import java.sql.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.AutoPopulatingList;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.loska.dao.InvoiceDAO;
import com.loska.dao.UserDAO;
import com.loska.model.Invoice;
import com.loska.model.InvoiceRow;
import com.loska.model.User;
import com.loska.util.InvoiceFormBackingBean;
import com.loska.util.InvoiceFormConverter;
import com.loska.util.UserSession;

@Controller
@RequestMapping(value="/newInvoice")
public class NewInvoiceController {
	@Autowired
	private UserSession userSession;
	@Autowired
	private InvoiceDAO invoiceDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private Validator validator;
	
    @InitBinder
    public void setDataBinder(WebDataBinder dataBinder) {
        dataBinder.setAutoGrowNestedPaths(false);
    }
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getNewInvoiceForm(ModelMap model){
		InvoiceFormBackingBean form = new InvoiceFormBackingBean();
		
		InvoiceRow row = new InvoiceRow();
//		row.setName("Nimi");
//		row.setAmmount(1);
//		row.setPrice(15f);
//		row.setTax(24f);
		form.getRows().add(row);
		
		return new ModelAndView("newInvoice", "invoiceForm", form);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String createNewInvoice(@Valid @ModelAttribute InvoiceFormBackingBean form, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {
			return "newInvoice";
		}
		else  {
			//set date
//			java.util.Calendar cal = java.util.Calendar.getInstance(); 
//			java.sql.Date date = new Date(cal.getTimeInMillis());
//			form.setDate(date);
			
			//Get user from session
			int userId = userSession.getUserId();
			User user = userDAO.findByUserId(userId);
			
			InvoiceFormConverter converter = new InvoiceFormConverter();
			Invoice invoice = converter.convertFormToInvoice(form, user);
			invoiceDAO.insert(invoice);
		}
		return "redirect:index";
	}

}
