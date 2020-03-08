package com.example.SayNoToHunger.DataLayer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.SayNoToHunger.DataLayer.InterfacesDL.ITrackFoodDonationsDL;
import com.example.SayNoToHunger.Model.FoodDonationStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

@Repository
public class TrackFoodDonationsDL implements ITrackFoodDonationsDL {

	@Autowired
	private Environment applicationProperties;

	public List<FoodDonationStatus> GetFoodDonationStatus(int foodDonationId) {
		Connection connection;
		List<FoodDonationStatus> foodDonationStatus = null;
		String connectionString = applicationProperties.getProperty("connectionString");
		try {
			connection =  DriverManager.getConnection(connectionString);
			if(connection != null){
				foodDonationStatus = new ArrayList<FoodDonationStatus>();
				CallableStatement statement = connection.prepareCall("{call [dbo].[sp_GetFoodDonationStatus](?)}");
				statement.setInt("foodDonationId", foodDonationId);
				ResultSet resultSet = statement.executeQuery();
				FoodDonationStatus status;
				while(resultSet.next()){
					status =  new FoodDonationStatus();
					status.Action = resultSet.getString("Action");
					status.ActionPerformedBy = resultSet.getInt("ActionPerformedBy");
					status.ActionDescription = resultSet.getString("ActionDescription");
					status.FoodDonationId = resultSet.getInt("FoodDonationId");
					status.ActionPerformedOn = resultSet.getDate("ActionPerformedOn");
					status.ActionPerformedOnDateTime = status.ActionPerformedOn.toLocaleString();
					foodDonationStatus.add(status);
				}
			}
		} catch (Exception exception) {
			return null;
		}
		finally{
			connection = null;
		}
		return foodDonationStatus;
	}

	public boolean InsertFoodDonationStatus(FoodDonationStatus foodDonationStatus){
		Connection connection;
		String connectionString = applicationProperties.getProperty("connectionString");
		try {
			connection =  DriverManager.getConnection(connectionString);
			if(connection != null){
				CallableStatement statement = connection.prepareCall("{call [dbo].[sp_InsertFoodDonationStatus](?,?,?,?,?)}");
				statement.setInt("foodDonationId", foodDonationStatus.FoodDonationId);
				statement.setString("action", foodDonationStatus.Action);
				statement.setString("actionDesc", foodDonationStatus.ActionDescription);
				statement.setInt("actionPerformedBy", foodDonationStatus.ActionPerformedBy);
				statement.setString("actionPerformedOn", foodDonationStatus.ActionPerformedOn.toLocaleString());
				return statement.execute();
			}
		} catch (Exception exception) {
			return false;
		}
		finally{
			connection = null;
		}
		return true;

	}

}
