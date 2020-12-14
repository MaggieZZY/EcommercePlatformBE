package com.mercury.FinalProjectDemo.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="msi_order")
public class Order {
	@SequenceGenerator(name = "msi_order_id_seq", sequenceName = "MSI_ORDER_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator="msi_order_id_seq", strategy = GenerationType.AUTO)
	@Id
	private int id;
	
	@Column
	private Date purchaseDate;
	
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column
	private String phone;
	@Column
	private String address1;
	@Column
	private String address2;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private String zip;
	@Column
	private int deliveryStatus;
	@Column(name="user_id")
	private int userId;
	
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="order") // fetch查，cascade增删改
	private List<OrderProduct> purchases; // want to know order product for each order 
	
	public Order() {
		super();

	}

	public Order(int id, Date purchaseDate, String firstname, String lastname, String phone, String address1,
			String address2, String city, String state, String zip, int deliveryStatus, int userId,
			List<OrderProduct> purchases) {
		super();
		this.id = id;
		this.purchaseDate = purchaseDate;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.deliveryStatus = deliveryStatus;
		this.userId = userId;
		this.purchases = purchases;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public int getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(int deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<OrderProduct> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<OrderProduct> purchases) {
		this.purchases = purchases;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", purchaseDate=" + purchaseDate + ", firstname=" + firstname + ", lastname="
				+ lastname + ", phone=" + phone + ", address1=" + address1 + ", address2=" + address2 + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", deliveryStatus=" + deliveryStatus + ", userId=" + userId
				+ ", purchases=" + purchases + "]";
	}

	
}
