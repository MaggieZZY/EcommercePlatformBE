package com.mercury.FinalProjectDemo.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mercury.FinalProjectDemo.beans.Order;

public interface OrderDao extends JpaRepository<Order, Integer>{
	
	@Query("select o from Order o where o.userId = :userId")
	List<Order> findByUserId(@Param("userId") int userId);
	
}
