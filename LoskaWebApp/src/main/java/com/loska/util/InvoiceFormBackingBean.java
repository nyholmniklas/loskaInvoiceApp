package com.loska.util;

import java.sql.Date;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;

import com.loska.model.User;

@Component
@Scope(value="request")
public class InvoiceFormBackingBean {
	private int invoiceId;

//	private Integer reference;
	private Date date;
	private String description;
	@NotNull
	private Float totalsum;
	
	//Buyer
	private Integer buyerId;
	private String buyerAddress;
	private String buyerPostcode;
	private String buyerCity;

	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	public Integer getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}
//	public Integer getReference() {
//		return reference;
//	}
//	public void setReference(Integer reference) {
//		this.reference = reference;
//	}
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
	public String getBuyerAddress() {
		return buyerAddress;
	}
	public void setBuyerAddress(String buyerAddress) {
		this.buyerAddress = buyerAddress;
	}
	public String getBuyerPostcode() {
		return buyerPostcode;
	}
	public void setBuyerPostcode(String buyerPostcode) {
		this.buyerPostcode = buyerPostcode;
	}
	public String getBuyerCity() {
		return buyerCity;
	}
	public void setBuyerCity(String buyerCity) {
		this.buyerCity = buyerCity;
	}
	
	
}
