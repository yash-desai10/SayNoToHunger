package com.example.SayNoToHunger.Controller;

import java.util.List;

import com.example.SayNoToHunger.Model.RDashboard;
import com.example.SayNoToHunger.Model.ReceiverFoodOffering;
import com.example.SayNoToHunger.Model.ReceiverFoodRequest;
import com.example.SayNoToHunger.ServiceLayer.InterfacesSL.IRDashboardSL;
//Author:Bhavya

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class RDashboardController {

    @Autowired
    IRDashboardSL receiverDashboardService;

    @RequestMapping("/receiver")
    List<RDashboard> GetRDashboardStatus(int receiverId, int fooddonationId) {
		
        return receiverDashboardService.GetRDashboardStatus(receiverId,  fooddonationId);
    }

    @RequestMapping("/availableOfferings")
    List<ReceiverFoodOffering> getFoodOfferings(){
        return receiverDashboardService.getFoodOfferings();
    }

    @RequestMapping("/activeFoodRequests")
    List<ReceiverFoodRequest> getFoodRequests(int receiverId){
        return receiverDashboardService.getFoodRequests(receiverId);
    }
	
	@RequestMapping(value = "/acceptFoodOffering", method = RequestMethod.POST)
    Integer InsertAcceptFood(@RequestBody RDashboard acceptfood){
        return receiverDashboardService.InsertAcceptFood(acceptfood);
    }
}