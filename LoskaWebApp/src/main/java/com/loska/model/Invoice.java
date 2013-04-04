package com.loska.model;

import java.sql.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;


public class Invoice {
		private int invoice_id;
		private User user;
		@NotNull
		private Integer reference;
		private Date date;
//		@NotBlank
//		@NotNull

		private String description;
		@NotNull
		private Float totalsum;
		
		//Buyer
		private Buyer buyer;

		
		public int getInvoice_id() {
			return invoice_id;
		}
		public void setInvoice_id(int invoice_id) {
			this.invoice_id = invoice_id;
		}

		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public Integer getReference() {
			return reference;
		}
		public void setReference(Integer reference) {
			this.reference = reference;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Float getTotalsum() {
			return totalsum;
		}
		public void setTotalsum(Float totalsum) {
			this.totalsum = totalsum;
		}
		public Buyer getBuyer() {
			return buyer;
		}
		public void setBuyer(Buyer buyer) {
			this.buyer = buyer;
		}
		
}