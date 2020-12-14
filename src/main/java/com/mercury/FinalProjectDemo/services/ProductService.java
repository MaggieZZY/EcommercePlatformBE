package com.mercury.FinalProjectDemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.FinalProjectDemo.beans.Product;
import com.mercury.FinalProjectDemo.daos.ProductDao;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;
	
	public List<Product> getAll() {
		return productDao.findAll();
	}
	
	public Product getProductById(Integer id) {
		return productDao.findById(id).get();
	}
	
	public List<Product> getProductByCategory(Integer category_id) {
		return productDao.findByCategory(category_id);
	}
	
	public Product getProductByName(String name) {
		return productDao.findByName(name);
	}

	public List<Product> getProductsBySales() {
		return productDao.findBySales();
	}
	
}
