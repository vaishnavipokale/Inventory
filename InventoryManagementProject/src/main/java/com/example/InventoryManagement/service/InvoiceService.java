

package com.example.InventoryManagement.service;

import java.util.List;

import com.example.InventoryManagement.entity.Invoice;

public interface InvoiceService {
	
	Invoice saveInvoice(Invoice invoice);
	List<Invoice> getAllInvoice();
	Invoice getInvoiceById(long id);
	Invoice updateInvoice(Invoice invoice, long id);
	//void deleteInvoice(long id);
	void deleteInvoiceById(long id);
	
	
}
