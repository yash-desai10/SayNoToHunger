package com.example.SayNoToHunger.ServiceLayer;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SayNoToHunger.DataLayer.InterfacesDL.IAdminDashboardNewsItemDL;
import com.example.SayNoToHunger.Model.NewsItem;
import com.example.SayNoToHunger.ServiceLayer.InterfacesSL.IAdminDashboardNewsItemSL;

@Service
public class AdminDashboardNewsItemService implements IAdminDashboardNewsItemSL {

	@Autowired
	private IAdminDashboardNewsItemDL adminDashboardNewsItemDL;
	
	@Override
	public String addNewsItem(NewsItem newsEntry) {
		return adminDashboardNewsItemDL.addNewsItem(newsEntry);
	}

	@Override
	public String deleteNewsItem(String itemId) {
		return adminDashboardNewsItemDL.deleteNewsItem(itemId);
	}

	@Override
	public LinkedList<NewsItem> getAllNewsItems() {
		return adminDashboardNewsItemDL.getAllNewsItems();
	}

}
