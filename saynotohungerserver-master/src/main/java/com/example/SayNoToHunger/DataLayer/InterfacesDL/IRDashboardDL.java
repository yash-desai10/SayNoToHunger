package com.example.SayNoToHunger.DataLayer.InterfacesDL;

import java.util.List;

import com.example.SayNoToHunger.Model.RDashboard;
import com.example.SayNoToHunger.Model.ReceiverFoodOffering;
import com.example.SayNoToHunger.Model.ReceiverFoodRequest;

public interface IRDashboardDL{
	List<RDashboard> GetRDashboardStatus(int receiverId, int fooddonationId);
	List<ReceiverFoodOffering> getFoodOfferings();
	List<ReceiverFoodRequest> getFoodRequests(int receiverId);
	Integer InsertAcceptFood(RDashboard acceptfood);
}
