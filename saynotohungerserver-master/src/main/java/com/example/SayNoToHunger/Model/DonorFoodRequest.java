package com.example.SayNoToHunger.Model;

import java.util.Date;
// This class used to hold the food requests (made by the receievers) to be displayed in the donor dashboard
// Author: Jamuna
public class DonorFoodRequest {
    public int foodDonationId;
    public String receiverName;
    public String foodName;
    public String comments;
    public Date requiredOn;
    public int noOfServings;
}
