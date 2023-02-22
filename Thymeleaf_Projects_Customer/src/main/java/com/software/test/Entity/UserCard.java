package com.software.test.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserCard 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String cardholdername;
	private String cardholdernumber;
	private String cardexpdate;
	private String cardholderaddress;
	private Integer cardcvv;
	private String cardphonenumber;
	public UserCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserCard(Integer id, String cardholdername, String cardholdernumber, String cardexpdate,
			String cardholderaddress, Integer cardcvv, String cardphonenumber) {
		super();
		this.id = id;
		this.cardholdername = cardholdername;
		this.cardholdernumber = cardholdernumber;
		this.cardexpdate = cardexpdate;
		this.cardholderaddress = cardholderaddress;
		this.cardcvv = cardcvv;
		this.cardphonenumber = cardphonenumber;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCardholdername() {
		return cardholdername;
	}
	public void setCardholdername(String cardholdername) {
		this.cardholdername = cardholdername;
	}
	public String getCardholdernumber() {
		return cardholdernumber;
	}
	public void setCardholdernumber(String cardholdernumber) {
		this.cardholdernumber = cardholdernumber;
	}
	public String getCardexpdate() {
		return cardexpdate;
	}
	public void setCardexpdate(String cardexpdate) {
		this.cardexpdate = cardexpdate;
	}
	public String getCardholderaddress() {
		return cardholderaddress;
	}
	public void setCardholderaddress(String cardholderaddress) {
		this.cardholderaddress = cardholderaddress;
	}
	public Integer getCardcvv() {
		return cardcvv;
	}
	public void setCardcvv(Integer cardcvv) {
		this.cardcvv = cardcvv;
	}
	public String getCardphonenumber() {
		return cardphonenumber;
	}
	public void setCardphonenumber(String cardphonenumber) {
		this.cardphonenumber = cardphonenumber;
	}
	
	
}
