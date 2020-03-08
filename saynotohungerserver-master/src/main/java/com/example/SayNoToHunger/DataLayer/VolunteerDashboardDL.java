package com.example.SayNoToHunger.DataLayer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.example.SayNoToHunger.DataLayer.InterfacesDL.IVolunteerDashboardDL;
import com.example.SayNoToHunger.Model.OngoingDonation;

@Repository
public class VolunteerDashboardDL implements IVolunteerDashboardDL {
	private final String GET_SCHEDULED_DELIVERY = "{call [dbo].[sp_getScheduledDelivery](?)}";
	private final String GET_ONGOING_DONATIONS = "{call [dbo].[sp_getOngoingDonations]}";
	private final String CONFIRM_PARTICIPATION = "{call [dbo].[sp_confirmPrticipation](?,?)}";
	private final String REPORT_COMPLETION = "{call [dbo].[sp_reportCompletion](?)}";
	private final String CANCEL_PARTICIPATION = "{call [dbo].[sp_cancelParticipation](?)}";
	
	private Connection connection;
	@Autowired
	private Environment applicationProperties;
	
	@Override
	public OngoingDonation getScheduledDelivery(int userId) {
		try {
			String connectionString = applicationProperties.getProperty("connectionString");
			connection =  DriverManager.getConnection(connectionString);
			CallableStatement statement = connection.prepareCall(GET_SCHEDULED_DELIVERY);
			statement.setInt("VOLUNTEERID", userId);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				return mapOngoingDonation(resultSet);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new OngoingDonation();
	}
	
	@Override
	public LinkedList<OngoingDonation> getOngoingDonations() {
		LinkedList<OngoingDonation> ongoingDonations = new LinkedList<OngoingDonation>();
		OngoingDonation ongoingDonation;
		
		try {
			String connectionString = applicationProperties.getProperty("connectionString");
			connection =  DriverManager.getConnection(connectionString);
			CallableStatement statement = connection.prepareCall(GET_ONGOING_DONATIONS);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				ongoingDonation = mapOngoingDonation(resultSet);
				if(null != ongoingDonation) {
					ongoingDonations.add(ongoingDonation);
				}
			}
			
			return ongoingDonations;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ongoingDonations;
	}
	
	private OngoingDonation mapOngoingDonation(ResultSet resultSet) {
		OngoingDonation ongoingDonation = new OngoingDonation();
		try {
			ongoingDonation.setAcceptedOn(resultSet.getTimestamp("ACCEPTEDON"));
			ongoingDonation.setDonationId(resultSet.getInt("FOOD_DONATION_ID"));
			ongoingDonation.setDonorAddrLine1(resultSet.getString("DONOR_ADDRESSLINE1"));
			ongoingDonation.setDonorAddrLine2(resultSet.getString("DONOR_ADDRESSLINE2"));
			ongoingDonation.setDonorCity(resultSet.getString("DONOR_CITY"));
			ongoingDonation.setDonorId(resultSet.getInt("DONORID"));
			ongoingDonation.setReceiverAddrLine1(resultSet.getString("RECEIVER_ADDRESSLINE1"));
			ongoingDonation.setReceiverAddrLine2(resultSet.getString("RECEIVER_ADDRESSLINE2"));
			ongoingDonation.setReceiverCity(resultSet.getString("RECEIVER_CITY"));
			ongoingDonation.setReceiverId(resultSet.getInt("RECEIVERID"));
			return ongoingDonation;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String confirmPrticipation(int userId, int donationId) {
		try {
			String connectionString = applicationProperties.getProperty("connectionString");
			connection =  DriverManager.getConnection(connectionString);
			CallableStatement statement = connection.prepareCall(CONFIRM_PARTICIPATION);
			statement.setInt("VOLUNTEERID", userId);
			statement.setInt("FOODDONATIONID", donationId);
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"failure\"}";
		}

		return "{\"result\":\"success\"}";
	}

	@Override
	public String reportCompletion(int donationId) {
		try {
			String connectionString = applicationProperties.getProperty("connectionString");
			connection =  DriverManager.getConnection(connectionString);
			CallableStatement statement = connection.prepareCall(REPORT_COMPLETION);
			statement.setInt("ID", donationId);
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"failure\"}";
		}

		return "{\"result\":\"success\"}";
	}
	
	@Override
	public String cancelParticipation(int donationId) {
		try {
			String connectionString = applicationProperties.getProperty("connectionString");
			connection =  DriverManager.getConnection(connectionString);
			CallableStatement statement = connection.prepareCall(CANCEL_PARTICIPATION);
			statement.setInt("FOODDONATIONID", donationId);
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"failure\"}";
		}

		return "{\"result\":\"success\"}";
	}
}
