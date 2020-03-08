package com.example.SayNoToHunger.ServiceLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SayNoToHunger.DataLayer.InterfacesDL.IRegistrationDL;
import com.example.SayNoToHunger.Model.CurrentUser;
import com.example.SayNoToHunger.Model.UserModel;
import com.example.SayNoToHunger.ServiceLayer.InterfacesSL.IRegistrationSL;

@Service
public class RegistrationService implements IRegistrationSL {
	
	@Autowired
	IRegistrationDL registrationDL;

	@Override
	public boolean AddUser(UserModel usermodel) {
		return registrationDL.AddUser(usermodel);
	}
	public CurrentUser LoginUser(UserModel usermodel){
		return registrationDL.LoginUser(usermodel);
	}
	
}
