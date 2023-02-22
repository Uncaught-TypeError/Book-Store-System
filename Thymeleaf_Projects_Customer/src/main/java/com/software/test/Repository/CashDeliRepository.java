package com.software.test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.software.test.Entity.CashDeliInfo;

@Repository
public interface CashDeliRepository extends JpaRepository<CashDeliInfo, Integer>
{
	
}
