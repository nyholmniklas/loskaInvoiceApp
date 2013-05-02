package com.loska.util;

import com.loska.model.Address;
import com.loska.model.Customer;
import com.loska.model.User;

public class CustomerFormConverter {

	public Customer convertFormToCustomer(CustomerFormBackingBean form,
			User user) {
		Customer customer = new Customer();
		
		customer.setUser_id(user.getUser_Id());
		
		customer.setName(form.getName());
		customer.setY_tunnus(form.getY_tunnus());
		
		//Set ship to
		Address ship_to = new Address();
		ship_to.setName(form.getShip_to_name());
		ship_to.setName2(form.getShip_to_name2());
		ship_to.setAddress(form.getShip_to_address());
		ship_to.setPostcode(form.getShip_to_postcode());
		ship_to.setCity(form.getShip_to_city());
		ship_to.setCountry(form.getShip_to_country());
		customer.setShip_to(ship_to);
		
		//Set bill to
		Address bill_to = new Address();
		bill_to.setName(form.getBill_to_name());
		bill_to.setName2(form.getBill_to_name2());
		bill_to.setAddress(form.getBill_to_address());
		bill_to.setPostcode(form.getBill_to_postcode());
		bill_to.setCity(form.getBill_to_city());
		bill_to.setCountry(form.getBill_to_country());
		customer.setBill_to(bill_to);
		
		return customer;
	}

	
}
