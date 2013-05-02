package com.loska.model;

public class Customer {
		private Integer customer_id;
		private Integer user_id;
		private String name;
		private Address bill_to;
		private Address ship_to;
		private String y_tunnus;
		public Integer getCustomer_id() {
			return customer_id;
		}
		public void setCustomer_id(Integer customer_id) {
			this.customer_id = customer_id;
		}
		public Integer getUser_id() {
			return user_id;
		}
		public void setUser_id(Integer user_id) {
			this.user_id = user_id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Address getBill_to() {
			return bill_to;
		}
		public void setBill_to(Address bill_to) {
			this.bill_to = bill_to;
		}
		public Address getShip_to() {
			return ship_to;
		}
		public void setShip_to(Address ship_to) {
			this.ship_to = ship_to;
		}
		public String getY_tunnus() {
			return y_tunnus;
		}
		public void setY_tunnus(String y_tunnus) {
			this.y_tunnus = y_tunnus;
		}
		
		
}
