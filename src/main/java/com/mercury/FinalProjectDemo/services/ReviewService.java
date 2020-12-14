package com.mercury.FinalProjectDemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.FinalProjectDemo.beans.Review;
import com.mercury.FinalProjectDemo.daos.ReviewDao;
import com.mercury.FinalProjectDemo.http.Response;

@Service
public class ReviewService {
	
	@Autowired
	public ReviewDao reviewDao;

	public List<Review> getAll() {
		return reviewDao.findAll();
	}

	public Response save(Review review) {
		reviewDao.save(review);
		return new Response(true);
	}

	public List<Review> getReviewsByProductId(Integer productId) {
		return reviewDao.findReviewByProductId(productId);
	}
	
	
	
	
}
