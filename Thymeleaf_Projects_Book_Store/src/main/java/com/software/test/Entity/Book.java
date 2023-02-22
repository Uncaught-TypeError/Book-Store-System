package com.software.test.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Book 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String isbn;
	private float price;
	
	@OneToOne()
	private Author author;
	
	@ManyToOne()
	private Category category;
	
	private String img;
	private String pdfile;
	private String description;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(Integer id, String title, String isbn, float price, Author author, Category category, String img,
			String pdfile, String description) {
		super();
		this.id = id;
		this.title = title;
		this.isbn = isbn;
		this.price = price;
		this.author = author;
		this.category = category;
		this.img = img;
		this.pdfile = pdfile;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getPdfile() {
		return pdfile;
	}

	public void setPdfile(String pdfile) {
		this.pdfile = pdfile;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
