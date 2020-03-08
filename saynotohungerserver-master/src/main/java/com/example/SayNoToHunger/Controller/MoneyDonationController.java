package com.example.SayNoToHunger.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.SayNoToHunger.Model.MoneyDonationModel;
import com.example.SayNoToHunger.Model.UserModel;
import com.example.SayNoToHunger.ServiceLayer.InterfacesSL.IMoneyDonationSL;

@CrossOrigin
@RestController
public class MoneyDonationController {
	@Autowired
	IMoneyDonationSL moneyDonationSL;
	
	@RequestMapping(value = "/donateMoney", method = RequestMethod.POST)
    public boolean DonateMoney(@RequestBody MoneyDonationModel moneydonationmodel){
		System.out.println(moneydonationmodel.getAmount());
		System.out.println(moneydonationmodel.getDate());
        return moneyDonationSL.DonateMoney(moneydonationmodel);
    }

}
