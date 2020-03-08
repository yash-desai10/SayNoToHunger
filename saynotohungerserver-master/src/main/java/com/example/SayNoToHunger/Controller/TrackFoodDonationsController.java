package com.example.SayNoToHunger.Controller;

import java.util.List;

import com.example.SayNoToHunger.Model.FoodDonationStatus;
import com.example.SayNoToHunger.ServiceLayer.InterfacesSL.ITrackFoodDonationsSL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// https://spring.io/guides/gs/rest-service-cors/
@CrossOrigin
@RestController
public class TrackFoodDonationsController{

    @Autowired
	ITrackFoodDonationsSL trackFoodDonationsService;
    
    @RequestMapping("/getFoodDonationStatus")
    List<FoodDonationStatus> GetFoodDonationStatus(int foodDonationId) {
		
        return trackFoodDonationsService.GetFoodDonationStatus(foodDonationId);
    }

    @RequestMapping(value = "/insertFoodDonationStatus", method = RequestMethod.POST)
    boolean InsertFoodDonationStatus(@RequestBody FoodDonationStatus foodDonationStatus){
        return trackFoodDonationsService.InsertFoodDonationStatus(foodDonationStatus);
    }

    //To test whether application is working
    @RequestMapping("/")
    String hello() {
		
        return "Hello World!!!";
    }
}