package com.software.test.Entity;

import java.time.LocalDate;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Orders 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private Customer customer;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate orderdate;
	
	private Integer totalprice;
	private String status;
	private String payment;
	
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(Integer id, Customer customer, LocalDate orderdate, Integer totalprice, String status,
			String payment) {
		super();
		this.id = id;
		this.customer = customer;
		this.orderdate = orderdate;
		this.totalprice = totalprice;
		this.status = status;
		this.payment = payment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LocalDate getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(LocalDate orderdate) {
		this.orderdate = orderdate;
	}

	public Integer getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(Integer totalprice) {
		this.totalprice = totalprice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}
	
}
