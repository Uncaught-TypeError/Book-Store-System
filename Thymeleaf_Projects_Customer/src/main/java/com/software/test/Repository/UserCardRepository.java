package com.software.test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.software.test.Entity.UserCard;

@Repository
public interface UserCardRepository extends JpaRepository<UserCard, Integer>{

}
