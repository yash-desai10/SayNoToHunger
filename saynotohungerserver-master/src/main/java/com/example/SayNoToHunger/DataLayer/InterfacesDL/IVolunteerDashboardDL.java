package com.example.SayNoToHunger.DataLayer.InterfacesDL;

import java.util.LinkedList;

import com.example.SayNoToHunger.Model.OngoingDonation;

public interface IVolunteerDashboardDL {
	public LinkedList<OngoingDonation> getOngoingDonations();
	public String confirmPrticipation(int userId, int donationId);
	public String reportCompletion(int donationId);
	public String cancelParticipation(int donationId);
	public OngoingDonation getScheduledDelivery(int userId);
}
