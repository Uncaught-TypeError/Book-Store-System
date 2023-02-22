package com.software.test.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.software.test.Entity.Book;
import com.software.test.Entity.Category;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	@Query("select p from Book p where p.category.name = ?1")
	List<Book> findbycatbookname(String name);
	
	/*
	 * @Query("select p from Book p where p.category.name = ?1") List<Book>
	 * findbycatbookname2(Category category);
	 */
}
