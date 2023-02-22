package com.software.test.Entity;

public class Cart extends Book{
	private Integer quantity;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * public Cart(Integer id, String title, String isbn, Integer price, Author
	 * author, Category category, String img, String pdfile) { super(id, title,
	 * isbn, price, author, category, img, pdfile); // TODO Auto-generated
	 * constructor stub }
	 */
	
	
	
	public Cart(Integer quantity) {
		super();
		this.quantity = quantity;
	}

	public Cart(Integer id, String title, String isbn, float price, Author author, Category category, String img,
			String pdfile, String description) {
		super(id, title, isbn, price, author, category, img, pdfile, description);
		// TODO Auto-generated constructor stub
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	
}
