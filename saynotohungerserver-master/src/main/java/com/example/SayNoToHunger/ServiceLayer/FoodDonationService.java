package com.example.SayNoToHunger.ServiceLayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SayNoToHunger.DataLayer.InterfacesDL.IFoodDonationDL;
import com.example.SayNoToHunger.Model.AcceptFoodRequestModel;
import com.example.SayNoToHunger.Model.DonorFoodOffering;
import com.example.SayNoToHunger.Model.DonorFoodRequest;
import com.example.SayNoToHunger.Model.FoodDonation;
import com.example.SayNoToHunger.ServiceLayer.InterfacesSL.IFoodDonationSL;

@Service
public class FoodDonationService implements IFoodDonationSL {

	@Autowired
	IFoodDonationDL foodDonationDL;
	
	@Override
	public Integer donateFood(FoodDonation foodDonation) {
		return foodDonationDL.saveFoodDonation(foodDonation);
	}
	
	@Override
	public List<FoodDonation> listAllDonations() {
		return foodDonationDL.listAllDonations();
	}

	@Override
	public List<DonorFoodOffering> getFoodOfferings(int donorId) {
		return foodDonationDL.getFoodOfferings(donorId);
	}

	@Override
	public List<DonorFoodRequest> getFoodRequests() {
		return foodDonationDL.getFoodRequests();
	}
	
	public boolean AcceptFoodRequest(AcceptFoodRequestModel acceptFoodRequest) {
		return foodDonationDL.AcceptFoodRequest(acceptFoodRequest);
	}
}
