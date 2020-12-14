package com.mercury.FinalProjectDemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.FinalProjectDemo.beans.Product;
import com.mercury.FinalProjectDemo.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@GetMapping
	public List<Product> getAll() {
		return productService.getAll();
	}
	
	@GetMapping("/id/{id}")
	public Product getProductById(@PathVariable int id) {
		return productService.getProductById(id);
	}
	
	@GetMapping("/name/{name}")
	public Product getProductByName(@PathVariable String name) {
		return productService.getProductByName(name);
	}

	@GetMapping("/category/{category_id}")
	public List<Product> getProductByCategory(@PathVariable int category_id) {
		return productService.getProductByCategory(category_id);
	}
	
	@GetMapping("/sales")
	public List<Product> getProductsBySales() {
		return productService.getProductsBySales();
	}
}
