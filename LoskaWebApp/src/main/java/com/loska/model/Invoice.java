package com.loska.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;


public class Invoice {
		private int invoice_id;
		private User user;
		private Customer customer;
		private Address	ship_to;
		private Address bill_to;
		private int terms;
		private int reference;
		private int number;
		private Date date;
		private Date due_date;
		private String description;
		private float totalsum;
		private String bank_account;
		private String company_name;
		private List<InvoiceRow> rows;
		
		public int getInvoice_id() {
			return invoice_id;
		}
		public void setInvoice_id(int invoice_id) {
			this.invoice_id = invoice_id;
		}
		public Customer getCustomer() {
			return customer;
		}
		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
		public Address getShip_to() {
			return ship_to;
		}
		public void setShip_to(Address ship_to) {
			this.ship_to = ship_to;
		}
		public Address getBill_to() {
			return bill_to;
		}
		public void setBill_to(Address bill_to) {
			this.bill_to = bill_to;
		}
		public int getTerms() {
			return terms;
		}
		public void setTerms(int terms) {
			this.terms = terms;
		}
		public int getReference() {
			return reference;
		}
		public void setReference(int reference) {
			this.reference = reference;
		}
		public int getNumber() {
			return number;
		}
		public void setNumber(int number) {
			this.number = number;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public Date getDue_date() {
			return due_date;
		}
		public void setDue_date(Date due_date) {
			this.due_date = due_date;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String descsription) {
			this.description = descsription;
		}
		public float getTotalsum() {
			return totalsum;
		}
		public void setTotalsum(float totalsum) {
			this.totalsum = totalsum;
		}
		public String getBank_account() {
			return bank_account;
		}
		public void setBank_account(String bank_account) {
			this.bank_account = bank_account;
		}
		public String getCompany_name() {
			return company_name;
		}
		public void setCompany_name(String company_name) {
			this.company_name = company_name;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public List<InvoiceRow> getRows() {
			return rows;
		}
		public void setRows(List<InvoiceRow> rows) {
			this.rows = rows;
		}

		
		
}
