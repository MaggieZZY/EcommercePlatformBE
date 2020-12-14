package com.mercury.FinalProjectDemo.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="msi_review")
public class Review {
	
	@SequenceGenerator(name = "msi_review_id_seq", sequenceName = "MSI_REVIEW_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator="msi_review_id_seq", strategy = GenerationType.AUTO)
	@Id
	private int id;
	
	@Column
	private Date reviewDate;
	@Column
	private int generalRating;
	@Column
	private int quality;
	@Column
	private int comfortness;
	@Column
	private int delivery;
	@Column
	private String summary;
	@Column
	private String generalComment;
	@Column
	private int userId;
	@Column 
	private String username;
	@Column
	private int productId;
	
	
	
	public Review() {
		super();
	}



	public Review(int id, Date reviewDate, int generalRating, int quality, int comfortness, int delivery,
			String summary, String generalComment, int userId, String username, int productId) {
		super();
		this.id = id;
		this.reviewDate = reviewDate;
		this.generalRating = generalRating;
		this.quality = quality;
		this.comfortness = comfortness;
		this.delivery = delivery;
		this.summary = summary;
		this.generalComment = generalComment;
		this.userId = userId;
		this.username = username;
		this.productId = productId;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Date getReviewDate() {
		return reviewDate;
	}



	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}



	public int getGeneralRating() {
		return generalRating;
	}



	public void setGeneralRating(int generalRating) {
		this.generalRating = generalRating;
	}



	public int getQuality() {
		return quality;
	}



	public void setQuality(int quality) {
		this.quality = quality;
	}



	public int getComfortness() {
		return comfortness;
	}



	public void setComfortness(int comfortness) {
		this.comfortness = comfortness;
	}



	public int getDelivery() {
		return delivery;
	}



	public void setDelivery(int delivery) {
		this.delivery = delivery;
	}



	public String getSummary() {
		return summary;
	}



	public void setSummary(String summary) {
		this.summary = summary;
	}



	public String getGeneralComment() {
		return generalComment;
	}



	public void setGeneralComment(String generalComment) {
		this.generalComment = generalComment;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public int getProductId() {
		return productId;
	}



	public void setProductId(int productId) {
		this.productId = productId;
	}



	@Override
	public String toString() {
		return "Review [id=" + id + ", reviewDate=" + reviewDate + ", generalRating=" + generalRating + ", quality="
				+ quality + ", comfortness=" + comfortness + ", delivery=" + delivery + ", summary=" + summary
				+ ", generalComment=" + generalComment + ", userId=" + userId + ", username=" + username
				+ ", productId=" + productId + "]";
	}
	
	
}
