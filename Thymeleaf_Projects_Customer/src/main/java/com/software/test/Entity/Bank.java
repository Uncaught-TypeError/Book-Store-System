package com.software.test.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bank 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String cardholder;
	private String cardnumber;
	private String expdate;
	private float balance;
	private String holderaddress;
	private Integer cvv;
	
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bank(Integer id, String cardholder, String cardnumber, String expdate, float balance, String holderaddress,
			Integer cvv) {
		super();
		this.id = id;
		this.cardholder = cardholder;
		this.cardnumber = cardnumber;
		this.expdate = expdate;
		this.balance = balance;
		this.holderaddress = holderaddress;
		this.cvv = cvv;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCardholder() {
		return cardholder;
	}
	public void setCardholder(String cardholder) {
		this.cardholder = cardholder;
	}
	public String getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
	public String getExpdate() {
		return expdate;
	}
	public void setExpdate(String expdate) {
		this.expdate = expdate;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public String getHolderaddress() {
		return holderaddress;
	}
	public void setHolderaddress(String holderaddress) {
		this.holderaddress = holderaddress;
	}
	public Integer getCvv() {
		return cvv;
	}
	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}
	
}
