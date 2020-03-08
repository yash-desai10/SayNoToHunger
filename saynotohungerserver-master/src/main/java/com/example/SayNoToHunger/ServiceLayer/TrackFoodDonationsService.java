package com.example.SayNoToHunger.ServiceLayer;

import java.util.List;

import com.example.SayNoToHunger.DataLayer.InterfacesDL.ITrackFoodDonationsDL;
import com.example.SayNoToHunger.Model.FoodDonationStatus;
import com.example.SayNoToHunger.ServiceLayer.InterfacesSL.ITrackFoodDonationsSL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackFoodDonationsService implements ITrackFoodDonationsSL {

	@Autowired
	ITrackFoodDonationsDL trackFoodDonationDL;
	public List<FoodDonationStatus> GetFoodDonationStatus(int foodDonationId) {
		//Business logic & calls to DL
		return trackFoodDonationDL.GetFoodDonationStatus(foodDonationId);
	}

	@Override
	public boolean InsertFoodDonationStatus(FoodDonationStatus foodDonationStatus) {
		trackFoodDonationDL.InsertFoodDonationStatus(foodDonationStatus);
		return true;
	}
}
