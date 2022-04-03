package com.example.InventoryManagement.entity;


import java.util.List;

import javax.persistence.CascadeType;

//import java.util.List;

//import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
@Data
@Entity
@Table(name="InventoryCustomerTbl")
public class Customer {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private long id;
	@NotBlank(message="First name can't be Empty")
	@NotNull(message="Please enter First name ")
    @Column(name="first_name")
	private String firstName;
	@NotBlank(message="Last name can't be empty")
	@NotNull(message="Please enter Last name")
	@Column(name="last_name")
	private String lastName;
	@NotBlank(message="Email can't be empty")
	@NotNull(message="Please enter Email")
	@Email
	@Column(name="email" , unique=true)
	private String email;
	@NotBlank(message="Contact Number can't be empty")
	@NotNull(message="Please enter Contact Number")
	
	@Column(name="contact_No" ,unique=true)
	private String contactNo;
	@Column(name="address")
	private String address;
	
	@OneToMany(mappedBy="customer", cascade = CascadeType.REMOVE, orphanRemoval = true)
	List<Product> product;
	
    @OneToMany(mappedBy="customer" , cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<Invoice> invoice;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public List<Invoice> getInvoice() {
		return invoice;
	}

	public void setInvoice(List<Invoice> invoice) {
		this.invoice = invoice;
	}

	
	
	
	public Customer(long id,
			@NotBlank(message = "First name can't be Empty") @NotNull(message = "Please enter First name ") String firstName,
			@NotBlank(message = "Last name can't be empty") @NotNull(message = "Please enter Last name") String lastName,
			@NotBlank(message = "Email can't be empty") @NotNull(message = "Please enter Email") @Email String email,
			@NotBlank(message = "Contact Number can't be empty") @NotNull(message = "Please enter Contact Number") String contactNo,
			String address, List<Product> product, List<Invoice> invoice) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNo = contactNo;
		this.address = address;
		this.product = product;
		this.invoice = invoice;
	}

	
	public Customer(
			@NotBlank(message = "First name can't be Empty") @NotNull(message = "Please enter First name ") String firstName,
			@NotBlank(message = "Last name can't be empty") @NotNull(message = "Please enter Last name") String lastName,
			@NotBlank(message = "Email can't be empty") @NotNull(message = "Please enter Email") @Email String email,
			@NotBlank(message = "Contact Number can't be empty") @NotNull(message = "Please enter Contact Number") String contactNo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNo = contactNo;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", contactNo=" + contactNo + ", address=" + address +  ", product="
				+ product + ", invoice=" + invoice + "]";
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Object getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPassword(Object password) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}