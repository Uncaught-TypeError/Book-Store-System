package com.software.test.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.software.test.Entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	@Query("select p from Category p where p.name = ?1")
	List<Category> findbyname(String name);
}
