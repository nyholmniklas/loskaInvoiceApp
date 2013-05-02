package com.loska.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.loska.model.Customer;

@Component
public interface CustomerDAO {
	public abstract void insertCustomer(Customer customer);
	public abstract Customer findCustomerById(int customerId);
	public abstract List<Customer> findAllCustomersForUserId(int userId);
}
