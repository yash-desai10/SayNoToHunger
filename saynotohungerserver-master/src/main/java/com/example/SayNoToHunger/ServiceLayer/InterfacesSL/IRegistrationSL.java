package com.example.SayNoToHunger.ServiceLayer.InterfacesSL;
import com.example.SayNoToHunger.Model.CurrentUser;
import com.example.SayNoToHunger.Model.UserModel;

public interface IRegistrationSL 
{
	boolean AddUser(UserModel usermodel);
	CurrentUser LoginUser(UserModel usermodel);
}
