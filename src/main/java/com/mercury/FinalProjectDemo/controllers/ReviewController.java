package com.mercury.FinalProjectDemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.FinalProjectDemo.beans.Review;
import com.mercury.FinalProjectDemo.services.ReviewService;


@RestController
@RequestMapping("/reviews")
public class ReviewController {
	
	@Autowired
	public ReviewService reviewService;
	
	@GetMapping
	public List<Review> getAll() {
		return reviewService.getAll();
	}
	
	
	@GetMapping("/productId/{productId}")
	public List<Review> getReviewsByProductId(@PathVariable Integer productId) {
		return reviewService.getReviewsByProductId(productId);
	}
	
	@PostMapping
	public void save(@RequestBody Review review) {
		reviewService.save(review);
	}
}
