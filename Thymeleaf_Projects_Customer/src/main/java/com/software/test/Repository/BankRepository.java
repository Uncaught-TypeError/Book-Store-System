package com.software.test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.software.test.Entity.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer>{
	@Query("select a from Bank a where a.cardnumber = ?1 and a.cvv = ?2")
	Bank findbycardnumcvv(String cardnumber, Integer cvv);
	
}
