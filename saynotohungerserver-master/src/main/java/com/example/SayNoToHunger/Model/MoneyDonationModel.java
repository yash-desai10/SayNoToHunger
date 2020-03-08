package com.example.SayNoToHunger.Model;

import java.sql.Date;

public class MoneyDonationModel 
{
	public int amount;
	public Date date;
	
	public int getAmount()
	{
		return amount;
	}
	
	public void setAmount(int amount)
	{
		this.amount=amount;
	}
	
	public Date getDate()
	{
		return date;
	}
	
	public void setDate(Date date)
	{
		this.date=date;
	}
	
	
}
