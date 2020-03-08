package com.example.SayNoToHunger.Model;

import java.sql.Date;

// This class is used to hold the food donation tracking details
// Abinaya Raja
public class FoodDonationStatus {

    public int FoodDonationId; 
    public String Action;
    public String ActionDescription;
    public int ActionPerformedBy;
	public Date ActionPerformedOn;
	public String ActionPerformedOnDateTime;
	public String status;
	public Date date;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}