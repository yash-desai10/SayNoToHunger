package com.example.SayNoToHunger.ServiceLayer.InterfacesSL;

import java.util.List;

import com.example.SayNoToHunger.Model.RDashboard;
import com.example.SayNoToHunger.Model.ReceiverFoodOffering;
import com.example.SayNoToHunger.Model.ReceiverFoodRequest;
//Author:Bhavya
public interface IRDashboardSL {
	List<RDashboard> GetRDashboardStatus(int receiverId, int fooddonationId);
	List<ReceiverFoodOffering> getFoodOfferings();
	List<ReceiverFoodRequest> getFoodRequests(int receiverId);
	Integer InsertAcceptFood(RDashboard acceptfood);
}
