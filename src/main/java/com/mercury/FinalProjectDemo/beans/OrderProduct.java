package com.mercury.FinalProjectDemo.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mercury.FinalProjectDemo.http.Response;

@Entity
@Table(name="msi_order_product")
public class OrderProduct {
	@SequenceGenerator(name = "msi_order_product_id_seq", sequenceName = "MSI_ORDER_PRODUCT_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator="msi_order_product_id_seq", strategy = GenerationType.AUTO)
	@Id
	private int id;
	@Column
	private int qty;
	@Column
	private int reviewStatus;
	
	
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.DETACH) // table增删改不影响order table & product table
	@JoinColumn(name="ORDER_ID")
	private Order order;
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.DETACH) 
	@JoinColumn(name="PRODUCT_ID")
	private Product product;
	
	public OrderProduct() {
		super();
	}

	public OrderProduct(int id, int qty, int reviewStatus, Order order, Product product) {
		super();
		this.id = id;
		this.qty = qty;
		this.reviewStatus = reviewStatus;
		this.order = order;
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getReviewStatus() {
		return reviewStatus;
	}

	public void setReviewStatus(int reviewStatus) {
		this.reviewStatus = reviewStatus;
	}

	@JsonIgnore 
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "OrderProduct [id=" + id + ", qty=" + qty + ", reviewStatus=" + reviewStatus + ", order=" + order
				+ ", product=" + product + "]";
	}

	
	
}
