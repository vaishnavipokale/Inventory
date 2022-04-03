


package com.example.InventoryManagement.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.InventoryManagement.entity.Invoice;
import com.example.InventoryManagement.service.InvoiceService;
@RestController
@RequestMapping("/api/inventoryinvoice")
public class InvoiceController {
	private InvoiceService invoiceService;
	//private InvoiceController userInvoice;

	public InvoiceController(InvoiceService invoiceService) {
		super();
		this.invoiceService = invoiceService;
	}
	
	@PostMapping
	public ResponseEntity<Invoice> saveInvoice(@RequestBody Invoice invoice) {
		return new ResponseEntity<Invoice>(invoiceService.saveInvoice(invoice),HttpStatus.CREATED);
	}
	

	@GetMapping
	public List<Invoice> getAllInvoice()
	{
		return invoiceService.getAllInvoice();
	}
	@GetMapping("{id}")
	public ResponseEntity<Invoice>getInvoiceById(@PathVariable("id") long id) {
		return new ResponseEntity<Invoice>(invoiceService.getInvoiceById(id), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Invoice> updateInvoice(@PathVariable("id") long id, @RequestBody Invoice invoice){
		
		return new ResponseEntity<Invoice>(invoiceService.updateInvoice(invoice, id),HttpStatus.OK);
		
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteInvoice(@PathVariable("id") long id){
		invoiceService.deleteInvoiceById(id);
		return new ResponseEntity<String> ("User Record Is Deleted", HttpStatus.OK);
	}
	
}
