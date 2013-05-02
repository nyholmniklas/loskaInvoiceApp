package com.loska.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="request")
public class CustomerFormBackingBean {
	private Integer userId;
	private String name;
	private String y_tunnus;
	private String customer_id;
	
	//Ship to
	private String ship_to_name;
	private String ship_to_name2;
	private String ship_to_address;
	private String ship_to_postcode;
	private String ship_to_city;
	private String ship_to_country;
	
	//Bill to
	private String bill_to_name;
	private String bill_to_name2;
	private String bill_to_address;
	private String bill_to_postcode;
	private String bill_to_city;
	private String bill_to_country;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getY_tunnus() {
		return y_tunnus;
	}
	public void setY_tunnus(String y_tunnus) {
		this.y_tunnus = y_tunnus;
	}
	public String getShip_to_name() {
		return ship_to_name;
	}
	public void setShip_to_name(String ship_to_name) {
		this.ship_to_name = ship_to_name;
	}
	public String getShip_to_name2() {
		return ship_to_name2;
	}
	public void setShip_to_name2(String ship_to_name2) {
		this.ship_to_name2 = ship_to_name2;
	}
	public String getShip_to_address() {
		return ship_to_address;
	}
	public void setShip_to_address(String ship_to_address) {
		this.ship_to_address = ship_to_address;
	}
	public String getShip_to_postcode() {
		return ship_to_postcode;
	}
	public void setShip_to_postcode(String ship_to_postcode) {
		this.ship_to_postcode = ship_to_postcode;
	}
	public String getShip_to_city() {
		return ship_to_city;
	}
	public void setShip_to_city(String ship_to_city) {
		this.ship_to_city = ship_to_city;
	}
	public String getShip_to_country() {
		return ship_to_country;
	}
	public void setShip_to_country(String ship_to_country) {
		this.ship_to_country = ship_to_country;
	}
	public String getBill_to_name() {
		return bill_to_name;
	}
	public void setBill_to_name(String bill_to_name) {
		this.bill_to_name = bill_to_name;
	}
	public String getBill_to_name2() {
		return bill_to_name2;
	}
	public void setBill_to_name2(String bill_to_name2) {
		this.bill_to_name2 = bill_to_name2;
	}
	public String getBill_to_address() {
		return bill_to_address;
	}
	public void setBill_to_address(String bill_to_address) {
		this.bill_to_address = bill_to_address;
	}
	public String getBill_to_postcode() {
		return bill_to_postcode;
	}
	public void setBill_to_postcode(String bill_to_postcode) {
		this.bill_to_postcode = bill_to_postcode;
	}
	public String getBill_to_city() {
		return bill_to_city;
	}
	public void setBill_to_city(String bill_to_city) {
		this.bill_to_city = bill_to_city;
	}
	public String getBill_to_country() {
		return bill_to_country;
	}
	public void setBill_to_country(String bill_to_country) {
		this.bill_to_country = bill_to_country;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	
}
