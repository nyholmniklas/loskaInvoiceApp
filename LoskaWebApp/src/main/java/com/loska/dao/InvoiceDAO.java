package com.loska.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.loska.model.invoice.Invoice;

@Component
public interface InvoiceDAO {
	public abstract Invoice findInvoiceById(int id);
	public abstract List<Invoice> getAllInvoicesBelongingToUserId(int user_Id);
}
