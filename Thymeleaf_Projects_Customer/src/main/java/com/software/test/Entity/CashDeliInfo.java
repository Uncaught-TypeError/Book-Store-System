package com.software.test.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CashDeliInfo 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String cusemail;
	private String cusnumber;
	private String cusaddress;
	private String cusname;
	public CashDeliInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CashDeliInfo(Integer id, String cusemail, String cusnumber, String cusaddress, String cusname) {
		super();
		this.id = id;
		this.cusemail = cusemail;
		this.cusnumber = cusnumber;
		this.cusaddress = cusaddress;
		this.cusname = cusname;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCusemail() {
		return cusemail;
	}
	public void setCusemail(String cusemail) {
		this.cusemail = cusemail;
	}
	public String getCusnumber() {
		return cusnumber;
	}
	public void setCusnumber(String cusnumber) {
		this.cusnumber = cusnumber;
	}
	public String getCusaddress() {
		return cusaddress;
	}
	public void setCusaddress(String cusaddress) {
		this.cusaddress = cusaddress;
	}
	public String getCusname() {
		return cusname;
	}
	public void setCusname(String cusname) {
		this.cusname = cusname;
	}
	
	
}
