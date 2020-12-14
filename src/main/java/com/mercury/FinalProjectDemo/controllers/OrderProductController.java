package com.mercury.FinalProjectDemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.FinalProjectDemo.beans.Order;
import com.mercury.FinalProjectDemo.beans.OrderProduct;
import com.mercury.FinalProjectDemo.http.Response;
import com.mercury.FinalProjectDemo.services.OrderProductService;

@RestController
@RequestMapping("/orderproducts")
public class OrderProductController {
	@Autowired 
	private OrderProductService orderProductService;
	
	@PutMapping
	public Response updateOrderProduct(@RequestBody OrderProduct orderProduct) {
		return orderProductService.updateOrderProduct(orderProduct);
	}
}
