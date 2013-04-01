package com.loska.session;

import java.sql.Date;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;

import com.loska.model.User;

@Component
@Scope(value="session")
public class NewInvoiceFormBackingBean {
	private int invoice_id;
//	private User user;
	@NotNull
	private Integer reference;
	private Date date;
//	@NotBlank
//	@NotNull
	private Integer buyer_id;
	private String description;
	@NotNull
	private Float totalsum;
	public int getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}

//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
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
	public Integer getBuyer_id() {
		return buyer_id;
	}
	public void setBuyer_id(Integer buyer_id) {
		this.buyer_id = buyer_id;
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
}
