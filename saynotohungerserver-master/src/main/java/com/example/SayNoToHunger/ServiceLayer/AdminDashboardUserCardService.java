package com.example.SayNoToHunger.ServiceLayer;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SayNoToHunger.DataLayer.InterfacesDL.IAdminDashboardUserCardDL;
import com.example.SayNoToHunger.Model.OngoingDonation;
import com.example.SayNoToHunger.Model.UserCard;
import com.example.SayNoToHunger.ServiceLayer.InterfacesSL.IAdminDashboardUserCardSL;

@Service
public class AdminDashboardUserCardService implements IAdminDashboardUserCardSL {

	@Autowired
	private IAdminDashboardUserCardDL adminDashboardUserCardDL;
	
	@Override
	public UserCard getUserCardById(String userId) {
		return adminDashboardUserCardDL.getUserCardById(userId);
	}
	
	@Override
	public LinkedList<UserCard> getNewApplications() {
		return adminDashboardUserCardDL.getNewApplications();
	}

	@Override
	public LinkedList<UserCard> getInactiveApplications() {
		return adminDashboardUserCardDL.getInactiveApplications();
	}

	@Override
	public LinkedList<UserCard> getRegularUsers() {
		return adminDashboardUserCardDL.getRegularUsers();
	}

	@Override
	public LinkedList<UserCard> getSuspendedUsers() {
		return adminDashboardUserCardDL.getSuspendedUsers();
	}

	@Override
	public LinkedList<UserCard> getUserCards(String status) {
		return adminDashboardUserCardDL.getUserCards(status);
	}

	@Override
	public String deleteUserByID(String userId) {
		return adminDashboardUserCardDL.deleteUserByID(userId);
	}

	@Override
	public String approveApplicationByUserID(String userId) {
		return adminDashboardUserCardDL.approveApplicationByUserID(userId);
	}

	@Override
	public String declineApplicationByUserID(String userId) {
		return adminDashboardUserCardDL.declineApplicationByUserID(userId);
	}

	@Override
	public String suspendUserByID(String userId) {
		return adminDashboardUserCardDL.suspendUserByID(userId);
	}

	@Override
	public String resumeUserByID(String userId) {
		return adminDashboardUserCardDL.resumeUserByID(userId);
	}
}
