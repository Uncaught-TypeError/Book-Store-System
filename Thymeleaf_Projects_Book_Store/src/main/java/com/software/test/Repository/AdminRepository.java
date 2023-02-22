package com.software.test.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.software.test.Entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>
{
	@Query("select a from Admin a where a.username = ?1 and a.password = ?2")
	Admin findbyuserandpass(String username, String password);
	
//	Admin findByEmail(String email);
}
