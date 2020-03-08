package com.example.SayNoToHunger.ServiceLayer.InterfacesSL;

import java.util.List;

import com.example.SayNoToHunger.Model.FoodDonationStatus;

public interface ITrackFoodDonationsSL {
	List<FoodDonationStatus> GetFoodDonationStatus(int foodDonationId);
	boolean InsertFoodDonationStatus(FoodDonationStatus foodDonationStatus);
}
