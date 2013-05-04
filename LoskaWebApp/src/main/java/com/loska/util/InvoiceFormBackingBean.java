package com.loska.util;

import java.sql.Date;
import java.util.Iterator;


import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;
import org.springframework.util.AutoPopulatingList;
import org.springframework.context.annotation.Scope;


import com.loska.model.InvoiceRow;

@Component
@Scope(value = "request")
public class InvoiceFormBackingBean {
	private int invoiceId;

	// private Integer reference;

	private Date date;

	private Date due_date;
	// private String description;

	// Ship to
//	@NotBlank
	private String ship_to_name;
	private String ship_to_name2;
//	@NotBlank
	private String ship_to_address;
//	@NotBlank
	private String ship_to_postcode;
//	@NotBlank
	private String ship_to_city;
//	@NotBlank
	private String ship_to_country;

	// Bill to
//	@NotBlank
	private String bill_to_name;
	private String bill_to_name2;
//	@NotBlank
	private String bill_to_address;
//	@NotBlank
	private String bill_to_postcode;
//	@NotBlank
	private String bill_to_city;
//	@NotBlank
	private String bill_to_country;

	// Product rows
	private AutoPopulatingList<InvoiceRow> rows = new AutoPopulatingList<InvoiceRow>(
			InvoiceRow.class);

	// Getters and setters
	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
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

	public AutoPopulatingList<InvoiceRow> getRows() {
		return rows;
	}

	public void setRows(AutoPopulatingList<InvoiceRow> rows) {
		this.rows = rows;
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

	public void shrinkRows() {
		synchronized (rows) {
			for (Iterator i = this.rows.iterator(); i.hasNext();) {
				if (i.next() == null) {
					i.remove();
				}
			}
		}
	}

}
