package com.software.test.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.software.test.Entity.Author;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>
{
	@Query("select p from Author p where p.name = ?1")
	List<Author> findbyname(String name);
}
