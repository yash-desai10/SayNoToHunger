package com.example.SayNoToHunger.DataLayer.InterfacesDL;

import com.example.SayNoToHunger.Model.CurrentUser;
import com.example.SayNoToHunger.Model.UserModel;

public interface IRegistrationDL {
	boolean AddUser(UserModel usermodel);
	CurrentUser LoginUser(UserModel usermodel);
}
