package com.example.SayNoToHunger.ServiceLayer.InterfacesSL;

import java.util.LinkedList;

import com.example.SayNoToHunger.Model.UserCard;

public interface IAdminDashboardUserCardSL {
	public LinkedList<UserCard>  getNewApplications();
	public LinkedList<UserCard>  getInactiveApplications();
	public LinkedList<UserCard> getRegularUsers();
	public LinkedList<UserCard> getSuspendedUsers();
	public LinkedList<UserCard> getUserCards(String status);
	public String deleteUserByID(String userId);
	public String approveApplicationByUserID(String userId);
	public String declineApplicationByUserID(String userId);
	public String suspendUserByID(String userId);
	public String resumeUserByID(String userId);
	public UserCard getUserCardById(String userId);
}
