package com.example.SayNoToHunger.ServiceLayer;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.List;

import com.example.SayNoToHunger.DataLayer.InterfacesDL.IRequestFoodDL;
import com.example.SayNoToHunger.Model.Requestfood;
import com.example.SayNoToHunger.ServiceLayer.InterfacesSL.IRequestFoodService;

@Service
public class RequestfoodService implements IRequestFoodService {
//Author:Bhavya
	@Autowired
	IRequestFoodDL requestFoodDL;
	// public List<Requestfood> GetRequestfood(int Fooddonationid) {
	// 	//Business logic & calls to DL
	// 	return testTrackRequestFoodDL.GetRequestFood(Fooddonationid);
	// }

	public Integer InsertRequestfood(Requestfood foodrequest) {
		return requestFoodDL.InsertRequestfood(foodrequest);
	}


	public List<Requestfood> GetRequestfood(int receiverId) {
		return requestFoodDL.GetRequestFood(receiverId);
	}

	
	



	

}  