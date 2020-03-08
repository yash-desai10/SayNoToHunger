package com.example.SayNoToHunger.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SayNoToHunger.Model.AcceptFoodRequestModel;
import com.example.SayNoToHunger.Model.DonorFoodOffering;
import com.example.SayNoToHunger.Model.DonorFoodRequest;
import com.example.SayNoToHunger.Model.FoodDonation;
import com.example.SayNoToHunger.Model.FoodDonationStatus;
import com.example.SayNoToHunger.ServiceLayer.InterfacesSL.IFoodDonationSL;

@CrossOrigin
@RestController
public class FoodDonationRestController {

	@Autowired
	IFoodDonationSL foodDonationService;

	@GetMapping("/listAllDonations")
	public List<FoodDonation> listAllDonations() {
		try {
			return foodDonationService.listAllDonations();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@PostMapping("/donateFood")
	@ResponseBody
	public Integer donateFood(@RequestBody FoodDonation foodDonation) {
		try {
			return foodDonationService.donateFood(foodDonation);
			//return true;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	@RequestMapping("/activeFoodOfferings")
	public List<DonorFoodOffering> getFoodOfferings(int donorId) {
		return foodDonationService.getFoodOfferings(donorId);
	}

	@RequestMapping("/availableFoodRequests")
	public List<DonorFoodRequest> getFoodRequests() {
		return foodDonationService.getFoodRequests();
	}

	@RequestMapping(value = "/acceptFoodRequest", method = RequestMethod.POST)
    boolean AcceptFoodRequest(@RequestBody AcceptFoodRequestModel acceptFoodReq){
        return foodDonationService.AcceptFoodRequest(acceptFoodReq);
    }
}
