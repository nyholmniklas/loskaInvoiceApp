package com.loska.model;

import java.sql.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;


public class Invoice {
		private int invoice_id;
		private int user_id;
		@NotBlank
		@NotNull
		private int reference;
		private Date date;
		@NotBlank
		@NotNull
		private int buyer_id;
		private String description;
		@NotBlank
		@NotNull
		private float totalsum;
		
		public int getInvoice_id() {
			return invoice_id;
		}
		public void setInvoice_id(int invoice_id) {
			this.invoice_id = invoice_id;
		}
		public int getUser_id() {
			return user_id;
		}
		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}
		public int getReference() {
			return reference;
		}
		public void setReference(int reference) {
			this.reference = reference;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public int getBuyer_id() {
			return buyer_id;
		}
		public void setBuyer_id(int buyer_id) {
			this.buyer_id = buyer_id;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public float getTotalsum() {
			return totalsum;
		}
		public void setTotalsum(float totalsum) {
			this.totalsum = totalsum;
		}
		
		
}
