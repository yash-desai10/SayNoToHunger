package com.example.SayNoToHunger.DataLayer.InterfacesDL;

import java.util.List;

import com.example.SayNoToHunger.Model.Requestfood;
//Author:Bhavya

public interface IRequestFoodDL{
    
    List<Requestfood> GetRequestFood(int receiverId);
    Integer InsertRequestfood(Requestfood foodrequest);
}