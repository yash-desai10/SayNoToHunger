package com.example.SayNoToHunger.DataLayer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.example.SayNoToHunger.DataLayer.InterfacesDL.IAdminDashboardUserCardDL;
import com.example.SayNoToHunger.Model.OngoingDonation;
import com.example.SayNoToHunger.Model.UserCard;

@Repository
public class AdminDashboardUserCardDL implements IAdminDashboardUserCardDL {
	private final String SP_GET_USER_CARD_BY_ID = "{call [dbo].[sp_getUserCardById](?)}";
	private final String SP_GET_USER_CARDS_BY_USER_STATUS = "{call [dbo].[sp_getUserCardsByUserStatus](?)}";
	private final String SP_APPROVE_APPLICATION_BY_ID = "{call [dbo].[sp_approveApplicationById](?)}";
	private final String SP_DECLINE_APPLICATION_BY_ID = "{call [dbo].[sp_declineApplicationById](?)}";
	private final String SP_SUSPEND_USER_BY_ID = "{call [dbo].[sp_suspendUserById](?)}";
	private final String SP_RESUME_USER_BY_ID = "{call [dbo].[sp_resumeUserById](?)}";
	private final String DELETE_USER_BY_ID = "{call [dbo].[sp_deleteUserById](?)}";
	private Connection connection;
	@Autowired
	private Environment applicationProperties;
	//private final String connectionString = applicationProperties.getProperty("connectionString");
	
	@Override
	public UserCard getUserCardById(String userId) {
		UserCard userCard;
		String connectionString = applicationProperties.getProperty("connectionString");
		
		try {
			connection =  DriverManager.getConnection(connectionString);
			CallableStatement statement = connection.prepareCall(SP_GET_USER_CARD_BY_ID);
			statement.setInt("ID", Integer.parseInt(userId));
			ResultSet resultSet = statement.executeQuery();

			if(resultSet.next()) {
				userCard = mapUserCard(resultSet);
				return userCard;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new UserCard();
	}
	
	@Override
	public LinkedList<UserCard>  getNewApplications() {
		return getUserCards("New");
	}
	
	@Override
	public LinkedList<UserCard>  getInactiveApplications() {
		return getUserCards("Inactive");
	}
	
	@Override
	public LinkedList<UserCard> getRegularUsers() {
		return getUserCards("Regular");
	}
	
	@Override
	public LinkedList<UserCard> getSuspendedUsers() {
		return getUserCards("Suspended");
	}
	
	@Override
	public LinkedList<UserCard> getUserCards(String status) {
		LinkedList<UserCard> userCards = new LinkedList<UserCard>();
		UserCard userCard;
		String connectionString = applicationProperties.getProperty("connectionString");
		
		try {
			connection =  DriverManager.getConnection(connectionString);
			CallableStatement statement = connection.prepareCall(SP_GET_USER_CARDS_BY_USER_STATUS);
			statement.setString("STATUS", status);
			ResultSet resultSet = statement.executeQuery();

			while(resultSet.next()) {
				userCard = mapUserCard(resultSet);
				if(null != userCard) {
					userCards.add(userCard);
				}
			}
			
			return (userCards);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userCards;
	}

	private UserCard mapUserCard(ResultSet resultSet) {
		UserCard userCard = new UserCard();
		try {
			userCard.setUserId(resultSet.getInt("ID"));
			userCard.setUserFirstName(resultSet.getString("FIRSTNAME"));
			userCard.setUserLastName(resultSet.getString("LASTNAME"));
			userCard.setUserRole(resultSet.getString("ROLE"));
			userCard.setUserType(resultSet.getString("USERTYPE"));
			userCard.setUserPhone(Integer.toString(resultSet.getInt("PHONE")));
			userCard.setUserEmail(resultSet.getString("EMAIL"));
			userCard.setUserCity(resultSet.getString("CITY"));
			return userCard;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String deleteUserByID(String userId) {
		try {
			String connectionString = applicationProperties.getProperty("connectionString");
			connection =  DriverManager.getConnection(connectionString);
			CallableStatement statement = connection.prepareCall(DELETE_USER_BY_ID);
			statement.setInt("ID", Integer.parseInt(userId));
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"failure\"}";
		}

		return "{\"result\":\"success\"}";
	}

	@Override
	public String approveApplicationByUserID(String userId) {
		return executeUpdate(SP_APPROVE_APPLICATION_BY_ID, userId);
	}
	
	@Override
	public String declineApplicationByUserID(String userId) {
		return executeUpdate(SP_DECLINE_APPLICATION_BY_ID, userId);

	}

	@Override
	public String suspendUserByID(String userId) {
		return executeUpdate(SP_SUSPEND_USER_BY_ID, userId);
	}

	@Override
	public String resumeUserByID(String userId) {
		return executeUpdate(SP_RESUME_USER_BY_ID, userId);
	}
	
	
	private String executeUpdate(String sp_Call, String userId) {
		try {
			String connectionString = applicationProperties.getProperty("connectionString");
			connection =  DriverManager.getConnection(connectionString);
			CallableStatement statement = connection.prepareCall(sp_Call);
			statement.setInt("ID", Integer.parseInt(userId));
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"failure\"}";
		}

		return "{\"result\":\"success\"}";
	}
}
