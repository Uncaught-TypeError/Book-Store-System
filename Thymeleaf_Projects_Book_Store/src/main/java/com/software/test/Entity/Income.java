package com.software.test.Entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;


public interface Income 
{
	@DateTimeFormat(pattern="yyyy-MM-dd")
	LocalDate getOrderDate();
	Integer getTotalPrice();
	
	String getYear();
	String getMonth();
}
