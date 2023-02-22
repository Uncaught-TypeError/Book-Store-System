package com.software.test.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Delivery 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String deliaddress;
	private String phonenumber;
	private String deliname;
	
	public Delivery() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Delivery(Integer id, String deliaddress, String phonenumber, String deliname) {
		super();
		this.id = id;
		this.deliaddress = deliaddress;
		this.phonenumber = phonenumber;
		this.deliname = deliname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeliaddress() {
		return deliaddress;
	}

	public void setDeliaddress(String deliaddress) {
		this.deliaddress = deliaddress;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getDeliname() {
		return deliname;
	}

	public void setDeliname(String deliname) {
		this.deliname = deliname;
	}
	
	
}
