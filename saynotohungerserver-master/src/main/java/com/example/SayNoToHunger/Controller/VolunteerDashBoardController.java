package com.example.SayNoToHunger.Controller;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.SayNoToHunger.Model.OngoingDonation;
import com.example.SayNoToHunger.ServiceLayer.InterfacesSL.IVolunteerDashboardSL;

@CrossOrigin
@RestController
public class VolunteerDashBoardController implements WebMvcConfigurer{
	@Autowired
	private IVolunteerDashboardSL volunteerDashboardSL;
	
	@RequestMapping("/scheduledDelivery/{userId}")
	@ResponseBody
	public OngoingDonation getScheduledDelivery(@PathVariable String userId) {
        return volunteerDashboardSL.getScheduledDelivery(Integer.parseInt(userId));
    }
	
	@RequestMapping("/ongoingDonations")
	@ResponseBody
	public LinkedList<OngoingDonation> getOngoingDonations() {
        return volunteerDashboardSL.getOngoingDonations();
    }
	
	@RequestMapping("/confirmParticipation/{userId}/{donationId}")
	@ResponseBody
	public String confirmParticipation(@PathVariable String userId, @PathVariable String donationId) {
        return volunteerDashboardSL.confirmParticipation(Integer.parseInt(userId), Integer.parseInt(donationId));
    }
	
	@RequestMapping("/reportCompletion/{donationId}")
	@ResponseBody
	public String reportCompletion(@PathVariable String donationId) {
        return volunteerDashboardSL.reportCompletion(Integer.parseInt(donationId));
    }
	
	@RequestMapping("/cancelParticipation/{donationId}")
	@ResponseBody
	public String cancelParticipation(@PathVariable String donationId) {
        return volunteerDashboardSL.cancelParticipation(Integer.parseInt(donationId));
    }
}
