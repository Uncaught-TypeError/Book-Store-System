package com.software.test.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.software.test.Entity.OrderDetail;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer>
{
	@Query("select od from OrderDetail od where od.order.id=?1")
	public List<OrderDetail>findByOrderId(Integer id);
}
