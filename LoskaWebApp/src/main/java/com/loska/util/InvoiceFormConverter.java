package com.loska.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.loska.dao.InvoiceDAO;
import com.loska.dao.UserDAO;
import com.loska.model.Buyer;
import com.loska.model.Invoice;
import com.loska.model.User;

public class InvoiceFormConverter {

	
	public Invoice convertFormToInvoice(InvoiceFormBackingBean form,
			User user){
		Invoice invoice = new Invoice();
		
		Buyer buyer = new Buyer();
		//TEMP next line
		buyer.setBuyerId(0);
		buyer.setAddress(form.getBuyerAddress());
		buyer.setCity(form.getBuyerCity());
		buyer.setPostcode(form.getBuyerPostcode());
		invoice.setBuyer(buyer);
		
		invoice.setDate(form.getDate());
		invoice.setDescription(form.getDescription());
		invoice.setTotalsum(form.getTotalsum());
		invoice.setUser(user);
		return invoice;
	}
	
}
