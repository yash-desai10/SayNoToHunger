package com.example.SayNoToHunger.DataLayer;

import java.sql.Date;
import java.sql.Time;
import org.springframework.stereotype.Repository;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.Receiver;

import com.example.SayNoToHunger.Model.Requestfood;
import org.springframework.core.env.Environment;
import com.example.SayNoToHunger.DataLayer.InterfacesDL.IRequestFoodDL;
//Author:Bhavya
@Repository
public class RequestforfoodDL implements IRequestFoodDL{
    /* public Requestfood[] testDataLayerMethod1()
    {
        Requestfood[] result = new Requestfood[]{
            new Requestfood(){{
                foodname = "Gajar halwa";
                numberofservings = "2";
            }}
        };
        return result;

    } */
    @Autowired
	private Environment applicationProperties;

	public List<Requestfood> GetRequestFood(int receiverId) {
		Connection connection;
		List<Requestfood> foodrequeststatus = null;
		String connectionString = applicationProperties.getProperty("connectionString");
		try {
			connection =  DriverManager.getConnection(connectionString);
			if(connection != null){
				foodrequeststatus = new ArrayList<Requestfood>();
				CallableStatement statement = connection.prepareCall("{call [dbo].[sp_GetFoodRequests](?)}");
                statement.setInt("receiverId", receiverId);
				ResultSet resultSet = statement.executeQuery(); //execute is for update/delete/insert
				Requestfood foodRequest;
				while(resultSet.next()){
                    foodRequest =  new Requestfood();
                    foodRequest.foodname = resultSet.getString("FOODNAME");
                    foodRequest.numberofservings = resultSet.getInt("NOOFSERVINGS");
                    foodRequest.requestdate = resultSet.getDate("ACCEPTEDON");
                    //status.requesttime = resultSet.getTime("ActionPerformedBy");
                    foodRequest.comments = resultSet.getString("COMMENTS");
					foodrequeststatus.add(foodRequest);
				}
			}
		} catch (Exception exception) {
			return null;
		}
		finally{
			connection = null;
		}
		return foodrequeststatus;
	}

	public Integer InsertRequestfood(Requestfood foodrequest){
		Connection connection;
		String connectionString = applicationProperties.getProperty("connectionString");
		Integer foodDonationId = -1;
		try {
			connection =  DriverManager.getConnection(connectionString);
			if(connection != null){
				CallableStatement statement = connection.prepareCall("{call [dbo].[sp_InsertFoodRequest](?,?,?,?,?,?)}");
				statement.setInt("ReceiverID", foodrequest.receiverid);
				statement.setString("Foodname", foodrequest.foodname);
                statement.setInt("Noofservings", foodrequest.numberofservings);
                statement.setDate("acceptedOn", foodrequest.requestdate);
				statement.setString("Comments", foodrequest.comments);
				statement.registerOutParameter("foodDonationId", java.sql.Types.INTEGER);
				statement.execute();
				foodDonationId = statement.getInt("foodDonationId");
				return foodDonationId;
			}
		} catch (Exception exception) {
			return foodDonationId;
		}
		finally{
			connection = null;
		}
		return foodDonationId;

	}




    
}