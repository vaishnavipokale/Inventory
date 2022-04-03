
package com.example.InventoryManagement.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
//import javax.persistence.JoinTable;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

//import com.fasterxml.jackson.annotation.JsonBackReference;


import lombok.Data;
@Data
@Entity
@Table(name="InventoryProductTbl")
public class Product {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	
	private long id;
	@Column(name="product_name")
	private String productName;
	@Column(name="product_category")
	private String productCategory;
	@Column(name="product_price")
	private long productPrice;
	@Column(name="product_desc")
	private String productDesc;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="supplier_id")
	private Supplier supplier;
	
	@ManyToOne
	
    @JoinTable(name="product_customer",joinColumns = { @JoinColumn(name="product_id")},inverseJoinColumns = { @JoinColumn(name="customer_id")})
    
    private Customer customer;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public long getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product(long id, String productName, String productCategory, long productPrice, String productDesc,
			Supplier supplier, Customer customer) {
		super();
		this.id = id;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productPrice = productPrice;
		this.productDesc = productDesc;
		this.supplier = supplier;
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", productCategory=" + productCategory
				+ ", productPrice=" + productPrice + ", productDesc=" + productDesc + ", supplier=" + supplier
				+ ", customer=" + customer + "]";
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
