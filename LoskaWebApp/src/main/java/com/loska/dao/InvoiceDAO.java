package com.loska.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.loska.model.Invoice;
import com.loska.model.InvoiceRow;

@Component
public interface InvoiceDAO {
	public abstract void insert(Invoice invoice);
	public abstract Invoice findInvoiceById(int id);
	public abstract List<Invoice> getAllInvoicesBelongingToUserId(int user_Id);
	public abstract InvoiceRow findInvoiceRowById(int rowId);
	public abstract List<InvoiceRow> getAllRowsForInvoiceByInvoiceId(int invoiceId);
}
