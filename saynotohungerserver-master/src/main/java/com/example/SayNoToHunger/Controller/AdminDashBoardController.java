package com.example.SayNoToHunger.Controller;

import java.util.LinkedList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable ;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.SayNoToHunger.Model.NewsItem;
import com.example.SayNoToHunger.Model.UserCard;
import com.example.SayNoToHunger.ServiceLayer.InterfacesSL.IAdminDashboardNewsItemSL;
import com.example.SayNoToHunger.ServiceLayer.InterfacesSL.IAdminDashboardUserCardSL;

@CrossOrigin
@RestController
public class AdminDashBoardController implements WebMvcConfigurer {
	
	@Autowired
	private IAdminDashboardUserCardSL adminDashboardUserCardSL;
	@Autowired
	private IAdminDashboardNewsItemSL adminDashboardNewsItemSL;
	
	@RequestMapping("/getUserCard/{userId}")
	@ResponseBody
	public UserCard getUserCardById(@PathVariable String userId) {
        return adminDashboardUserCardSL.getUserCardById(userId);
    }
	
	@RequestMapping("/newApplications")
	@ResponseBody
	public LinkedList<UserCard> getNewApplications() {
        return adminDashboardUserCardSL.getNewApplications();
    }
	
	@RequestMapping("/inactiveApplications")
	@ResponseBody
	LinkedList<UserCard> getInactiveApplications() {
        return adminDashboardUserCardSL.getInactiveApplications();
    }
	
	@RequestMapping("/suspendedUsers")
	@ResponseBody
	public LinkedList<UserCard> getSuspendedUsers() {
        return adminDashboardUserCardSL.getSuspendedUsers();
    }
	
	@RequestMapping("/regularUsers")
	@ResponseBody
	public LinkedList<UserCard> getRegularUsers() {
        return adminDashboardUserCardSL.getRegularUsers();
    }
	
	@RequestMapping("/deleteInactiveApplication/{userId}")
	@ResponseBody
	public String deleteUser(@PathVariable String userId) {
        return adminDashboardUserCardSL.deleteUserByID(userId);
    }
	
	@RequestMapping("/approveApplication/{userId}")
	@ResponseBody
	public String approveApplication(@PathVariable String userId) {
        return adminDashboardUserCardSL.approveApplicationByUserID(userId);
    }
	
	@RequestMapping("/declineApplication/{userId}")
	@ResponseBody
	public String declineApplication(@PathVariable String userId) {
        return adminDashboardUserCardSL.declineApplicationByUserID(userId);
    }
	
	@RequestMapping("/suspendUser/{userId}")
	@ResponseBody
	public String suspendUser(@PathVariable String userId) {
        return adminDashboardUserCardSL.suspendUserByID(userId);
    }
	
	@RequestMapping("/resumeUser/{userId}")
	@ResponseBody
	public String resumeUser(@PathVariable String userId) {
        return adminDashboardUserCardSL.resumeUserByID(userId);
    }
	
	@PostMapping("/addNewsItem")
	@ResponseBody
	public String addNewsItem(@RequestBody NewsItem newsEntry) {
        return adminDashboardNewsItemSL.addNewsItem(newsEntry);
    }
	
	@RequestMapping("/deleteNewsItem/{itemId}")
	@ResponseBody
	public String deleteNewsItem(@PathVariable String itemId) {
        return adminDashboardNewsItemSL.deleteNewsItem(itemId);
    }
	
	@RequestMapping("/getNewsItems")
	@ResponseBody
	public LinkedList<NewsItem> getNewsItems() {
        return adminDashboardNewsItemSL.getAllNewsItems();
    }
}
