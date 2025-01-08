package model;

import java.sql.Date;

public class Review {

	private int productId;
	private int userId;
	private String firstName;
	private String lastName;
	private String image;
	private int rate;
	private String comment;
	private Date createdAt;

	public Review(int productId, int userId, int rate, String comment) {
		this.productId = productId;
		this.userId = userId;
		this.rate = rate;
		this.comment = comment;
	}
	public Review(int productId, int userId,String firstName, String lastName,String image, int rate, String comment,Date createdAt) {
		this.productId = productId;
		this.userId = userId;
		this.firstName=firstName;
		this.lastName=lastName;
		this.image=image;
		this.rate = rate;
		this.comment = comment;
		this.createdAt=createdAt;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Review [productId=" + productId + ", userId=" + userId + ", rate=" + rate + ", comment=" + comment
				+ "]";
	}

}
