package com.mercury.FinalProjectDemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mercury.FinalProjectDemo.beans.Order;
import com.mercury.FinalProjectDemo.beans.OrderProduct;
import com.mercury.FinalProjectDemo.beans.Product;
import com.mercury.FinalProjectDemo.daos.OrderDao;
import com.mercury.FinalProjectDemo.daos.OrderProductDao;
import com.mercury.FinalProjectDemo.daos.ProductDao;
import com.mercury.FinalProjectDemo.http.Response;

@Service
public class OrderService {
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private OrderProductDao orderProductDao;
	
	public List<Order> getAll(){
		return orderDao.findAll();
	}
	
	public Order getById(Integer id) {
		return orderDao.findById(id).get();
	}

	public List<Order> getByUserId(Integer userId) {
		return orderDao.findByUserId(userId); 
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.NEVER)
	public Response save(Order order) {
		try {
			List<OrderProduct> purchases = order.getPurchases();
			purchases.forEach((orderProduct) -> {
				Product product = (Product) productDao.findById(orderProduct.getProduct().getId()).get();
				orderProduct.setProduct(product); // this won't affect operation
				orderProduct.setOrder(order); // OrderProduct table has null order id so cannot insert without this line
			});
			orderDao.save(order);

			return new Response(true);
		} catch (Exception e) {
			return new Response(false);
		}
	}

	public Response updateOrder(Order order) {
		try {
			Order prevOrder = orderDao.findById(order.getId()).get();
			order.setId(prevOrder.getId());
			List<OrderProduct> purchases = order.getPurchases();
			purchases.forEach((orderProduct) -> {
				Product product = (Product) productDao.findById(orderProduct.getProduct().getId()).get();
				orderProduct.setProduct(product); // this won't affect operation
				orderProduct.setOrder(order); // OrderProduct table has null order id so cannot insert without this line
			});
			orderDao.save(order);
			return new Response(true, 200, "successfully update order", order);
		} catch (Exception e) {
			return new Response(false);
		}
	}

	public Response cancelOrder(Integer id) {
		orderDao.deleteById(id);
		return new Response(true, 200, "successfully delete order", id);
	}
	
	

}
