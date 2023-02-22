package com.software.test.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String rolename;
	
	public Role() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(Integer id, String rolename) 
	{
		super();
		this.id = id;
		this.rolename = rolename;
	}

	public Integer getId() 
	{
		return id;
	}

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public String getRolename() 
	{
		return rolename;
	}

	public void setRolename(String rolename) 
	{
		this.rolename = rolename;
	}
	
	
	
}
