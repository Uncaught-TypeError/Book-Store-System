package com.software.test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.software.test.Entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>
{
	
	Customer findByEmail(String email);
}
