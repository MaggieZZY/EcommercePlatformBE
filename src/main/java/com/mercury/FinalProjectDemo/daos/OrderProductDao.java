package com.mercury.FinalProjectDemo.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.FinalProjectDemo.beans.OrderProduct;

public interface OrderProductDao extends JpaRepository<OrderProduct, Integer>{

}
