package com.example.SayNoToHunger.DataLayer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.SayNoToHunger.DataLayer.InterfacesDL.IRDashboardDL;
import com.example.SayNoToHunger.Model.RDashboard;
import com.example.SayNoToHunger.Model.ReceiverFoodOffering;
import com.example.SayNoToHunger.Model.ReceiverFoodRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
//Author:Bhavya
@Repository
public class RDashboardDL implements IRDashboardDL {

	@Autowired
	private Environment applicationProperties;
	

	public List<RDashboard> GetRDashboardStatus(int receiverId, int fooddonationId) {
		Connection connection;
		List<RDashboard> dashboardstatus = null;
		String connectionString = applicationProperties.getProperty("connectionString");
		try {
			connection =  DriverManager.getConnection(connectionString);
			if(connection != null){
				dashboardstatus = new ArrayList<RDashboard>();
				CallableStatement statementr = connection.prepareCall("{call [dbo].[sp_GetFoodRequests](?)}");
				CallableStatement statementd = connection.prepareCall("{call [dbo].[sp_GetFoodDonationStatus](?)}");
				statementr.setInt("receiverId", receiverId);
				statementd.setInt("fooddonationId",fooddonationId);
			
				ResultSet resultSetd = statementd.executeQuery();
				RDashboard status1;
				
				while(resultSetd.next()){
					status1 =  new RDashboard();
					status1.foodname= resultSetd.getString("FOODNAME");;
					status1.numberofservings= resultSetd.getString("NOOFSERVINGS");
					status1. expirydate= resultSetd.getDate("EXPIRYDATE");;
					 status1.acceptedOn = resultSetd.getDate("ACCEPTEDON");
					 status1.receiverId = resultSetd.getInt("RECEIVERID");
 					 dashboardstatus.add(status1);
					}
				}
			} catch (Exception exception) {
				return null;
			}
			finally{
				connection = null;
			}
			return dashboardstatus;
		}

	@Override
	public List<ReceiverFoodOffering> getFoodOfferings() {
		Connection connection;
		List<ReceiverFoodOffering> foodOfferings = null;
		String connectionString = applicationProperties.getProperty("connectionString");
		try {
			connection =  DriverManager.getConnection(connectionString);
			if(connection != null){
				foodOfferings = new ArrayList<ReceiverFoodOffering>();
				CallableStatement statement = connection.prepareCall("{call [dbo].[sp_GetFoodOfferingsForReceiverDashboard]}");
				//statement.setInt("foodDonationId", foodDonationId);
				ResultSet resultSet = statement.executeQuery();
				ReceiverFoodOffering foodOffering;
				while(resultSet.next()){
					foodOffering =  new ReceiverFoodOffering();
					foodOffering.foodDonationId = resultSet.getInt("Id");
					foodOffering.foodName = resultSet.getString("FoodName");
					foodOffering.noOfServings = resultSet.getInt("NoOfServings");
					foodOffering.donorName = resultSet.getString("DonorName");
					foodOffering.comments = resultSet.getString("Comments");
					foodOffering.availableOn = resultSet.getDate("AvailableOn");
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
	public List<ReceiverFoodRequest> getFoodRequests(int receiverId) {
		Connection connection;
		List<ReceiverFoodRequest> foodRequests = null;
		String connectionString = applicationProperties.getProperty("connectionString");
		try {
			connection =  DriverManager.getConnection(connectionString);
			if(connection != null){
				foodRequests = new ArrayList<ReceiverFoodRequest>();
				CallableStatement statement = connection.prepareCall("{call [dbo].[sp_GetFoodRequestsForReceiverDashboard](?)}");
				statement.setInt("receiverId", receiverId);
				ResultSet resultSet = statement.executeQuery();
				ReceiverFoodRequest foodRequest;
				while(resultSet.next()){
					foodRequest =  new ReceiverFoodRequest();
					foodRequest.foodDonationId = resultSet.getInt("Id");
					foodRequest.donorName = resultSet.getString("DonorName");
					foodRequest.foodName = resultSet.getString("FoodName");
					foodRequest.noOfServings = resultSet.getInt("NoOfServings");
					foodRequest.comments = resultSet.getString("Comments");
					foodRequest.requiredOn = resultSet.getDate("RequiredOn");
					foodRequest.initiatedBy = resultSet.getString("InitiatedBy");
					foodRequests.add(foodRequest);
				}
			}
		} catch (Exception exception) {
			return null;
		}
		finally{
			connection = null;
		}
		return foodRequests;
	}
	
			public Integer InsertAcceptFood(RDashboard acceptfood){
			Connection connection;
			Integer queryExecStatus = -1;
			String connectionString = applicationProperties.getProperty("connectionString");
			try {
				connection =  DriverManager.getConnection(connectionString);
				if(connection != null){
					CallableStatement statement = connection.prepareCall("{call [dbo].[sp_AcceptFoodOffering](?,?,?)}");
					statement.setDate("acceptedOn", new java.sql.Date(System.currentTimeMillis()));
					statement.setInt("ReceiverID", acceptfood.receiverId);
					statement.setInt("foodDonationId", acceptfood.foodDonationId);
					queryExecStatus = statement.executeUpdate();
				}
			} catch (Exception exception) {
				return queryExecStatus;
			}
			finally{
				connection = null;
			}
			return queryExecStatus;
	
		}

	}
