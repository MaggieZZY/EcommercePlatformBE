package com.mercury.FinalProjectDemo.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mercury.FinalProjectDemo.beans.Review;

public interface ReviewDao extends JpaRepository <Review, Integer>{

	@Query("select r from Review r where r.productId = :productId")
	List<Review> findReviewByProductId(@Param("productId") int productId);
	
}
