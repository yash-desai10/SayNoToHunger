package com.example.SayNoToHunger.DataLayer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.example.SayNoToHunger.DataLayer.InterfacesDL.IMoneyDonationDL;
import com.example.SayNoToHunger.Model.MoneyDonationModel;
import com.example.SayNoToHunger.Model.UserModel;

@Service
public class MoneyDonationDL implements IMoneyDonationDL {
	@Autowired
	public Environment applicationProperties;

	
		
		@Override
		public boolean DonateMoney(MoneyDonationModel moneydonationmodel) 
		{
			
			Connection connection=null;
			CallableStatement callStatement=null;
			String connectionURL=applicationProperties.getProperty("connectionString");
//			String result = "Success";
			
			try 
			{
				connection = DriverManager.getConnection(connectionURL);
				callStatement = connection.prepareCall("{call [dbo].[sp_donateMoney](?,?)}");
				callStatement.setInt("Amount", moneydonationmodel.getAmount());
				callStatement.setDate("Date", moneydonationmodel.getDate());
				callStatement.execute();
				

			}  
			catch (Exception exception) {
				return false;
			}
			finally{
				connection = null;
			}
			return true;
			
			
		}
		
		
	}


