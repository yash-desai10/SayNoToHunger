package com.example.SayNoToHunger.ServiceLayer.InterfacesSL;

import java.util.List;

import com.example.SayNoToHunger.Model.AcceptFoodRequestModel;
import com.example.SayNoToHunger.Model.DonorFoodOffering;
import com.example.SayNoToHunger.Model.DonorFoodRequest;
import com.example.SayNoToHunger.Model.FoodDonation;

public interface IFoodDonationSL {
	Integer donateFood(FoodDonation foodDonation);
	List<FoodDonation> listAllDonations();
	List<DonorFoodOffering> getFoodOfferings(int donorId);
	List<DonorFoodRequest> getFoodRequests();
	boolean AcceptFoodRequest(AcceptFoodRequestModel acceptFoodRequest);
}
