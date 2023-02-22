package com.software.test.Entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Author 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String email;
	private String password;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dateBirth;
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Author(Integer id, String name, String email, String password, LocalDate dateBirth) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.dateBirth = dateBirth;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getDateBirth() {
		return dateBirth;
	}
	public void setDateBirth(LocalDate dateBirth) {
		this.dateBirth = dateBirth;
	}
	
}
