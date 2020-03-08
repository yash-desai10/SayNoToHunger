package com.example.SayNoToHunger.ServiceLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SayNoToHunger.DataLayer.InterfacesDL.IMoneyDonationDL;
import com.example.SayNoToHunger.Model.MoneyDonationModel;
import com.example.SayNoToHunger.ServiceLayer.InterfacesSL.IMoneyDonationSL;

@Service
public class MoneyDonationService implements IMoneyDonationSL {
	
	@Autowired
	IMoneyDonationDL moneyDonationDL;

	@Override
	public boolean DonateMoney(MoneyDonationModel moneydonationmodel) {
	return moneyDonationDL.DonateMoney(moneydonationmodel);
	}

}
