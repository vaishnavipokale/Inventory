

package com.example.InventoryManagement.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.InventoryManagement.entity.Invoice;
import com.example.InventoryManagement.exception.ResourceNotFound;
import com.example.InventoryManagement.repository.InvoiceRepository;
import com.example.InventoryManagement.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService{

	private InvoiceRepository invoiceRepository;
	
	
	public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
		super();
		this.invoiceRepository = invoiceRepository;
	}


	@Override
	public Invoice saveInvoice(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}


	@Override
	public List<Invoice> getAllInvoice() {
		return invoiceRepository.findAll();
		
	}


	@Override
	public Invoice getInvoiceById(long id) {
		Optional<Invoice> invoice = invoiceRepository.findById(id);
		if(invoice.isPresent()) {
			return invoice.get();
		}
		else {
          
			throw new ResourceNotFound("Invoice","Id",id);
		}
		
	}


	@Override
	public Invoice updateInvoice(Invoice invoice, long id) {
		Invoice inv = new Invoice();
	 try {
		   inv = invoiceRepository.findById(id).orElseThrow(
				 ()-> 		 new ResourceNotFound("Invoice","Id",id));
	} catch (ResourceNotFound e) {
		
		e.printStackTrace();
	}
	 inv.setTotalAmount(invoice.getTotalAmount());
	 inv.setCustomerId(invoice.getCustomerId());
	 inv.setDate(invoice.getDate());	 //inv.setProductPrice(invoice.getProductPrice());
	 //inv.setProductDesc(invoice.getProductDesc());
	
	 invoiceRepository.save(inv);
	return inv;
	}
	@Override
	public void deleteInvoiceById(long id) {
		invoiceRepository.findById(id).orElseThrow(()-> new ResourceNotFound("Invoice", "Id", id));
	    invoiceRepository.deleteById(id);
	
		
	}



}
