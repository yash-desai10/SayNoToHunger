package com.example.SayNoToHunger.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OngoingDonation {
	private Integer donationId = 0;
	private String acceptedOn = "";
	private Integer donorId = 0;
	private String donorAddrLine1 = "";
	private String donorAddrLine2 = "";
	private String donorCity = "";
	private Integer receiverId = 0;
	private String receiverAddrLine1 = "";
	private String receiverAddrLine2 = "";
	private String receiverCity = "";
	
	public Integer getDonationId() {
		return donationId;
	}
	public void setDonationId(Integer donationId) {
		this.donationId = donationId;
	}
	public String getAcceptedOn() {
		return acceptedOn;
	}
	public void setAcceptedOn(java.sql.Timestamp acceptedOn) {
		Date date = new Date();
		date.setTime(acceptedOn.getTime());
		String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
		this.acceptedOn = formattedDate;
	}
	public Integer getDonorId() {
		return donorId;
	}
	public void setDonorId(Integer donorId) {
		this.donorId = donorId;
	}
	public String getDonorAddrLine1() {
		return donorAddrLine1;
	}
	public void setDonorAddrLine1(String donorAddrLine1) {
		this.donorAddrLine1 = donorAddrLine1;
	}
	public String getDonorAddrLine2() {
		return donorAddrLine2;
	}
	public void setDonorAddrLine2(String donorAddrLine2) {
		this.donorAddrLine2 = donorAddrLine2;
	}
	public String getDonorCity() {
		return donorCity;
	}
	public void setDonorCity(String donorCity) {
		this.donorCity = donorCity;
	}
	public Integer getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(Integer receiverId) {
		this.receiverId = receiverId;
	}
	public String getReceiverAddrLine1() {
		return receiverAddrLine1;
	}
	public void setReceiverAddrLine1(String receiverAddrLine1) {
		this.receiverAddrLine1 = receiverAddrLine1;
	}
	public String getReceiverAddrLine2() {
		return receiverAddrLine2;
	}
	public void setReceiverAddrLine2(String receiverAddrLine2) {
		this.receiverAddrLine2 = receiverAddrLine2;
	}
	public String getReceiverCity() {
		return receiverCity;
	}
	public void setReceiverCity(String receiverCity) {
		this.receiverCity = receiverCity;
	}
}
