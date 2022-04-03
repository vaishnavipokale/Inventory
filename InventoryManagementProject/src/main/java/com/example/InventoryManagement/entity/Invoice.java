

package com.example.InventoryManagement.entity;






//import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
@Data
@Entity
@Table(name="InventoryInvoiceTbl")
public class Invoice {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private long id;
	@Column(name="total_amount")
	private String totalAmount;
	@Column(name="customerid")
	private String CustomerId;
	@Column(name="date")
	private String date;
	
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="cust_id")
	private Customer customer;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}


	public String getCustomerId() {
		return CustomerId;
	}


	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Invoice(long id, String totalAmount, String customerId, String date, Customer customer) {
		super();
		this.id = id;
		this.totalAmount = totalAmount;
		CustomerId = customerId;
		this.date = date;
		this.customer = customer;
	}


	@Override
	public String toString() {
		return "Invoice [id=" + id + ", totalAmount=" + totalAmount + ", CustomerId=" + CustomerId + ", date=" + date
				+ ", customer=" + customer + "]";
	}


	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
