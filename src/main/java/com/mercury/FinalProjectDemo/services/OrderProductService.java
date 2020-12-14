package com.mercury.FinalProjectDemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.FinalProjectDemo.beans.OrderProduct;
import com.mercury.FinalProjectDemo.daos.OrderProductDao;
import com.mercury.FinalProjectDemo.http.Response;

@Service
public class OrderProductService {
	@Autowired
	private OrderProductDao orderProductDao;

	public Response updateOrderProduct(OrderProduct orderProduct) {
		try {
			OrderProduct op = orderProductDao.findById(orderProduct.getId()).get();
			orderProduct.setId(op.getId());
			orderProduct.setOrder(op.getOrder());
			orderProduct.setProduct(op.getProduct());
			orderProductDao.save(orderProduct);
			return new Response(true,200,"", orderProduct);
		}
		catch (Exception e) {
			return new Response(false,200,"");
		}
	}
	
	
}
