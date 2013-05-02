package com.loska.model;

public class Customer {
		private int customerId;
		private int user_id;
		private String name;
		private Address bill_to;
		private Address ship_to;
		private String y_tunnus;
		
		public int getCustomerId() {
			return customerId;
		}
		public void setCustomerId(int customerId) {
			this.customerId = customerId;
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
		public int getUser_id() {
			return user_id;
		}
		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}
		
		
}
