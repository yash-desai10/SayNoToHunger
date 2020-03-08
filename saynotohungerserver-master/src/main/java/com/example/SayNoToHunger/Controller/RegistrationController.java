package com.example.SayNoToHunger.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.SayNoToHunger.Model.CurrentUser;
import com.example.SayNoToHunger.Model.UserModel;
import com.example.SayNoToHunger.ServiceLayer.InterfacesSL.IRegistrationSL;

@CrossOrigin
@RestController
public class RegistrationController {
	
	@Autowired
	IRegistrationSL registrationSL;
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public boolean AddUser(@RequestBody UserModel usermodel){
		System.out.println(usermodel.getEmail());
		System.out.println(usermodel.getFirstname());
        return registrationSL.AddUser(usermodel);
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public CurrentUser LoginUser(@RequestBody UserModel usermodel){
        return registrationSL.LoginUser(usermodel);
    }
	

}
