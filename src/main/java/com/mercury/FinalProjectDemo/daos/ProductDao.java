package com.mercury.FinalProjectDemo.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mercury.FinalProjectDemo.beans.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{

	Product findByName(String name);

	@Query("select p from Product p where p.categoryId =:categoryId")
    List<Product> findByCategory(@Param("categoryId") int categoryId);

	@Query("select p from Product p where p.discount = 1")
	List<Product> findBySales();
	
		
	

}
