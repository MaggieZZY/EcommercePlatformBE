package com.mercury.FinalProjectDemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.FinalProjectDemo.beans.Order;
import com.mercury.FinalProjectDemo.beans.UserInfo;
import com.mercury.FinalProjectDemo.http.Response;
import com.mercury.FinalProjectDemo.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@GetMapping
	public List<Order> getAll() {
		return orderService.getAll();
	}
	
	@GetMapping("/userId/{userId}")
	public List<Order> getOrdersByUserId(@PathVariable Integer userId) {
		return orderService.getByUserId(userId);
	}
	
	@GetMapping("/id/{id}")
	public Order getOrderById(@PathVariable Integer id) {
		return orderService.getById(id);
	}
	
	@PostMapping
	public Response save(@RequestBody Order order) {
		return orderService.save(order);
	}
	
	@PutMapping
	public Response updateOrder(@RequestBody Order order) {
		return orderService.updateOrder(order);
	}
	
	@DeleteMapping("/{id}")
	public Response cancelOrder(@PathVariable Integer id) {
		return orderService.cancelOrder(id);
	}
}
