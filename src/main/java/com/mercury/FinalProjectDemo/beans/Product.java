package com.mercury.FinalProjectDemo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="msi_product")
public class Product {
	@SequenceGenerator(name = "msi_product_seq_gen", sequenceName = "MSI_PRODUCT_SEQ", allocationSize = 1)
    @GeneratedValue(generator="msi_product_seq_gen", strategy = GenerationType.AUTO)
	@Id
	private int id;
	@Column
	private String name;
	@Column
	private String description;
	@Column
	private int categoryId;
	@Column
	private String material;
	@Column
	private String brand;
	@Column
	private int price;
	@Column
	private String image;
	@Column
	private int originalPrice;
	@Column
	private int discount;

	
	public Product() {
		super();
	}


	public Product(int id, String name, String description, int categoryId, String material, String brand, int price,
			String image, int originalPrice, int discount) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.categoryId = categoryId;
		this.material = material;
		this.brand = brand;
		this.price = price;
		this.image = image;
		this.originalPrice = originalPrice;
		this.discount = discount;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public String getMaterial() {
		return material;
	}


	public void setMaterial(String material) {
		this.material = material;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public int getOriginalPrice() {
		return originalPrice;
	}


	public void setOriginalPrice(int originalPrice) {
		this.originalPrice = originalPrice;
	}


	public int getDiscount() {
		return discount;
	}


	public void setDiscount(int discount) {
		this.discount = discount;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", categoryId=" + categoryId
				+ ", material=" + material + ", brand=" + brand + ", price=" + price + ", image=" + image
				+ ", originalPrice=" + originalPrice + ", discount=" + discount + "]";
	}

	
	
}
