package com.example.SayNoToHunger.DataLayer.InterfacesDL;

import java.util.List;

import com.example.SayNoToHunger.Model.FoodDonationStatus;

public interface ITrackFoodDonationsDL {
	List<FoodDonationStatus> GetFoodDonationStatus(int foodDonationId);
	boolean InsertFoodDonationStatus(FoodDonationStatus foodDonationStatus);
}
