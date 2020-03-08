package com.example.SayNoToHunger.ServiceLayer;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SayNoToHunger.DataLayer.InterfacesDL.IVolunteerDashboardDL;
import com.example.SayNoToHunger.Model.OngoingDonation;
import com.example.SayNoToHunger.ServiceLayer.InterfacesSL.IVolunteerDashboardSL;

@Service
public class VolunteerDashboardService implements IVolunteerDashboardSL {

	@Autowired
	private IVolunteerDashboardDL volunteerDashboardDL;
	
	@Override
	public LinkedList<OngoingDonation> getOngoingDonations() {
		return volunteerDashboardDL.getOngoingDonations();
	}

	@Override
	public String confirmParticipation(int userId, int donationId) {
		return volunteerDashboardDL.confirmPrticipation(userId, donationId);
	}

	@Override
	public String reportCompletion(int donationId) {
		return volunteerDashboardDL.reportCompletion(donationId);
	}

	@Override
	public String cancelParticipation(int donationId) {
		return volunteerDashboardDL.cancelParticipation(donationId);
	}

	@Override
	public OngoingDonation getScheduledDelivery(int userId) {
		return volunteerDashboardDL.getScheduledDelivery(userId);
	}

}
