package com.loska.model;

public class InvoiceRow {
	private Integer row_id;
	private String name;
	private Integer ammount;
	private Float price;
	private Float tax;
	
	public Integer getRow_id() {
		return row_id;
	}
	public void setRow_id(Integer row_id) {
		this.row_id = row_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAmmount() {
		return ammount;
	}
	public void setAmmount(Integer ammount) {
		this.ammount = ammount;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Float getTax() {
		return tax;
	}
	public void setTax(Float tax) {
		this.tax = tax;
	}
}
