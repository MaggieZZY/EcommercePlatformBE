package com.mercury.FinalProjectDemo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "msi_userdetails")
public class UserInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "msi_userdetails_id_seq")
	@SequenceGenerator(name = "msi_userdetails_id_seq", sequenceName = "MSI_USERDETAILS_ID_SEQ", allocationSize = 1)
	int id;
	@Column
	String firstname;
	@Column
	String lastname;
	@Column
	String phone;
	@Column
	String address1;
	@Column
	String address2;
	@Column
	String city;
	@Column
	String state;
	@Column
	String zip;
	@Column 
	int userId;

	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserInfo(int id, String firstname, String lastname, String phone, String address1, String address2,
			String city, String state, String zip, int userId) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", phone=" + phone
				+ ", address1=" + address1 + ", address2=" + address2 + ", city=" + city + ", state=" + state + ", zip="
				+ zip + ", userId=" + userId + "]";
	}

	
	
}
