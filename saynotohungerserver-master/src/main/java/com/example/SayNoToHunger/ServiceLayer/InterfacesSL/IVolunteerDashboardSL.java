package com.example.SayNoToHunger.ServiceLayer.InterfacesSL;

import java.util.LinkedList;

import com.example.SayNoToHunger.Model.OngoingDonation;

public interface IVolunteerDashboardSL {
	public LinkedList<OngoingDonation> getOngoingDonations();
	public String confirmParticipation(int userId, int donationId);
	public String reportCompletion(int donationId);
	public String cancelParticipation(int donationId);
	public OngoingDonation getScheduledDelivery(int userId);
}
