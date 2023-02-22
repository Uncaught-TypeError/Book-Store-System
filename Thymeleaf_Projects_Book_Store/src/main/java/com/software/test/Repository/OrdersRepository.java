package com.software.test.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.software.test.Entity.Income;
import com.software.test.Entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>
{
	@Query("select o.orderdate as orderDate, sum(o.totalprice) as totalPrice from Orders o where o.status = 'confirm' group by o.orderdate")
	List<Income> findbydailyincome();
	
	@Query("select year(o.orderdate) as year, month(o.orderdate) as month, sum(o.totalprice) as totalPrice from Orders o where o.status = 'confirm' group by month(o.orderdate)")
	List<Income> findbymonthlyincome();
	
	@Query("select year(o.orderdate) as year, sum(o.totalprice) as totalPrice from Orders o where o.status = 'confirm' group by year(o.orderdate)")
	List<Income> findbyyearlyincome();
	
	
}
