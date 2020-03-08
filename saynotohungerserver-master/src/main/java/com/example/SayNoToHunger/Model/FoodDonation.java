package com.example.SayNoToHunger.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * 
 FOODDONATIONS



RECEIVERID
ACCEPTEDON


 */
@Entity
@Table(name = "FOODDONATIONS")
public class FoodDonation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "FOODNAME")
	private String foodName;

	@Column(name = "NOOFSERVINGS")
	private Integer noOfServings;

	@Column(name = "FOODEXPIRYDATE")
	private Date foodExpiryDate;

	@Column(name = "DONATEDON")
	private Date donatedOn;

	@Column(name = "DONORID")
	private Integer donorId;

	@Column(name = "COMMENTS")
	private String comments;

	@Column(name = "STATUS")
	private String donationStatus;

	@Column(name = "ISACTIVE")
	private Integer isActive;

	@Column(name = "INITIATEDBY")
	private String initiatedBy;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public Integer getNoOfServings() {
		return noOfServings;
	}

	public void setNoOfServings(Integer noOfServings) {
		this.noOfServings = noOfServings;
	}

	public Date getFoodExpiryDate() {
		return foodExpiryDate;
	}

	public void setFoodExpiryDate(Date foodExpiryDate) {
		this.foodExpiryDate = foodExpiryDate;
	}

	public Date getDonatedOn() {
		return donatedOn;
	}

	public void setDonatedOn(Date donatedOn) {
		this.donatedOn = donatedOn;
	}

	public Integer getDonorId() {
		return donorId;
	}

	public void setDonorId(Integer donorId) {
		this.donorId = donorId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getDonationStatus() {
		return donationStatus;
	}

	public void setDonationStatus(String donationStatus) {
		this.donationStatus = donationStatus;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public String getInitiatedBy() {
		return initiatedBy;
	}

	public void setInitiatedBy(String initiatedBy) {
		this.initiatedBy = initiatedBy;
	}

	
}
