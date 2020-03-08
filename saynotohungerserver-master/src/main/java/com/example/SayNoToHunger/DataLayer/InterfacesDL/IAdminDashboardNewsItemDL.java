package com.example.SayNoToHunger.DataLayer.InterfacesDL;

import java.util.LinkedList;

import com.example.SayNoToHunger.Model.NewsItem;

public interface IAdminDashboardNewsItemDL {
	public String addNewsItem(NewsItem newsEntry);
	public String deleteNewsItem(String itemId);
	public LinkedList<NewsItem> getAllNewsItems();
}
