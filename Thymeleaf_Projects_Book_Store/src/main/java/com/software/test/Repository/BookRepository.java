package com.software.test.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.software.test.Entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	@Query("select p from Book p where p.title = ?1")
	List<Book> findbyname(String name);
}
