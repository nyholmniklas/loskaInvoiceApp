package com.loska.util;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.loska.dao.InvoiceDAO;
import com.loska.dao.UserDAO;
import com.loska.model.Address;
import com.loska.model.Invoice;
import com.loska.model.InvoiceRow;
import com.loska.model.User;

public class InvoiceFormConverter {

	
	public Invoice convertFormToInvoice(InvoiceFormBackingBean form,
			User user){
		Invoice invoice = new Invoice();
		
		//Set date
		invoice.setDate(form.getDate());

		//Set ship to
		Address ship_to = new Address();
		ship_to.setName(form.getShip_to_name());
		ship_to.setName2(form.getShip_to_name2());
		ship_to.setAddress(form.getShip_to_address());
		ship_to.setPostcode(form.getShip_to_postcode());
		ship_to.setCity(form.getShip_to_city());
		ship_to.setCountry(form.getShip_to_country());
		invoice.setShip_to(ship_to);
		
		//Set bill to
		Address bill_to = new Address();
		bill_to.setName(form.getBill_to_name());
		bill_to.setName2(form.getBill_to_name2());
		bill_to.setAddress(form.getBill_to_address());
		bill_to.setPostcode(form.getBill_to_postcode());
		bill_to.setCity(form.getBill_to_city());
		bill_to.setCountry(form.getBill_to_country());
		invoice.setBill_to(bill_to);
		
		//Set products rows
		ArrayList<InvoiceRow> rows = new ArrayList<InvoiceRow>();
		for (InvoiceRow row:form.getRows()) {
			rows.add(row);
		}
		invoice.setRows(rows);
		
		invoice.setUser(user);
		return invoice;
	}
	
}
