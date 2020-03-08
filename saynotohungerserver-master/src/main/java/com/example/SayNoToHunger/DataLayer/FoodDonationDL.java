package com.example.SayNoToHunger.DataLayer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.example.SayNoToHunger.DataLayer.InterfacesDL.IFoodDonationDL;
import com.example.SayNoToHunger.Model.AcceptFoodRequestModel;
import com.example.SayNoToHunger.Model.DonorFoodOffering;
import com.example.SayNoToHunger.Model.DonorFoodRequest;
import com.example.SayNoToHunger.Model.FoodDonation;
import com.example.SayNoToHunger.repo.FoodDonationRepository;

@Service
public class FoodDonationDL implements IFoodDonationDL {

	@Autowired
	private Environment applicationProperties;
	
	@Autowired
	private FoodDonationRepository foodDonationRepository;
	
	@Override
	public Integer saveFoodDonation(FoodDonation foodDonation) {
		foodDonationRepository.save(foodDonation);
		return foodDonation.getId();
	}
	
	@Override
	public List<FoodDonation> listAllDonations() {
		return (List<FoodDonation>) foodDonationRepository.findAll();
	}

	@Override
	public List<DonorFoodOffering> getFoodOfferings(int donorId) {
		Connection connection;
		List<DonorFoodOffering> foodOfferings = null;
		String connectionString = applicationProperties.getProperty("connectionString");
		try {
			connection =  DriverManager.getConnection(connectionString);
			if(connection != null){
				foodOfferings = new ArrayList<DonorFoodOffering>();
				CallableStatement statement = connection.prepareCall("{call [dbo].[sp_GetFoodOfferingsForDonorDashboard](?)}");
				statement.setInt("donorId", donorId);
				ResultSet resultSet = statement.executeQuery();
				DonorFoodOffering foodOffering;
				while(resultSet.next()){
					foodOffering =  new DonorFoodOffering();
					foodOffering.foodDonationId = resultSet.getInt("Id");
					foodOffering.foodName = resultSet.getString("FoodName");
					foodOffering.noOfServings = resultSet.getInt("NoOfServings");
					foodOffering.comments = resultSet.getString("Comments");
					foodOffering.donatedOn = resultSet.getDate("DonatedOn");
					foodOffering.initiatedBy = resultSet.getString("initiatedBy");
					foodOffering.receiverName = resultSet.getString("receiverName");
					foodOfferings.add(foodOffering);
				}
			}
		} catch (Exception exception) {
			return null;
		}
		finally{
			connection = null;
		}
		return foodOfferings;
	}

	@Override
	public List<DonorFoodRequest> getFoodRequests() {
		Connection connection;
		List<DonorFoodRequest> foodOfferings = null;
		String connectionString = applicationProperties.getProperty("connectionString");
		try {
			connection =  DriverManager.getConnection(connectionString);
			if(connection != null){
				foodOfferings = new ArrayList<DonorFoodRequest>();
				CallableStatement statement = connection.prepareCall("{call [dbo].[sp_GetFoodRequestsForDonorDashboard]}");
				ResultSet resultSet = statement.executeQuery();
				DonorFoodRequest foodOffering;
				while(resultSet.next()){
					foodOffering =  new DonorFoodRequest();
					foodOffering.foodDonationId = resultSet.getInt("Id");
					foodOffering.foodName = resultSet.getString("FoodName");
					foodOffering.noOfServings = resultSet.getInt("NoOfServings");
					foodOffering.comments = resultSet.getString("Comments");
					foodOffering.requiredOn = resultSet.getDate("RequiredOn");
					foodOffering.receiverName = resultSet.getString("receiverName");
					foodOfferings.add(foodOffering);
				}
			}
		} catch (Exception exception) {
			return null;
		}
		finally{
			connection = null;
		}
		return foodOfferings;
	}

	public boolean AcceptFoodRequest(AcceptFoodRequestModel acceptFoodRequest){
		Connection connection;
		String connectionString = applicationProperties.getProperty("connectionString");
		try {
			connection =  DriverManager.getConnection(connectionString);
			if(connection != null){
				CallableStatement statement = connection.prepareCall("{call [dbo].[sp_AcceptFoodRequest](?,?,?)}");
				statement.setInt("donorId", acceptFoodRequest.donorId);
				statement.setInt("foodDonationId", acceptFoodRequest.foodDonationId);
				statement.setDate("donatedOn", new java.sql.Date(System.currentTimeMillis()));
				return statement.executeUpdate() > 0;
			}
		} catch (Exception exception) {
			return false;
		}
		finally{
			connection = null;
		}
		return false;
	}

}



