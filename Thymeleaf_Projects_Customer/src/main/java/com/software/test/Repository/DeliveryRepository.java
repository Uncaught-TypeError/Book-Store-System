package com.software.test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.software.test.Entity.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer>{

}
