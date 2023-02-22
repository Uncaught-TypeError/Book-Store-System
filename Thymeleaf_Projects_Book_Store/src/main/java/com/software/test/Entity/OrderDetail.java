package com.software.test.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderDetail 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer quanprice;
	private Integer quantity;
	
	@ManyToOne
	private Book book;

	@ManyToOne
	private Orders order;

	public OrderDetail() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetail(Integer id, Integer quanprice, Integer quantity, Book book, Orders order) 
	{
		super();
		this.id = id;
		this.quanprice = quanprice;
		this.quantity = quantity;
		this.book = book;
		this.order = order;
	}

	public Integer getId() 
	{
		return id;
	}

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getQuanprice() 
	{
		return quanprice;
	}

	public void setQuanprice(Integer quanprice) 
	{
		this.quanprice = quanprice;
	}

	public Integer getQuantity() 
	{
		return quantity;
	}

	public void setQuantity(Integer quantity) 
	{
		this.quantity = quantity;
	}

	public Book getBook() 
	{
		return book;
	}

	public void setBook(Book book) 
	{
		this.book = book;
	}

	public Orders getOrder() 
	{
		return order;
	}

	public void setOrder(Orders order) 
	{
		this.order = order;
	}
	
}
