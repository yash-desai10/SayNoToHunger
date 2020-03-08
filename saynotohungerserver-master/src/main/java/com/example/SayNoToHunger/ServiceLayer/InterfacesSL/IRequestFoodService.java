package com.example.SayNoToHunger.ServiceLayer.InterfacesSL;

import java.util.List;

import com.example.SayNoToHunger.Model.Requestfood;
//Author:Bhavya
public interface IRequestFoodService {
	
	List<Requestfood> GetRequestfood(int receiverId);
	Integer InsertRequestfood(Requestfood foodrequest);
}