package com.example.SayNoToHunger.ServiceLayer.InterfacesSL;

import java.util.LinkedList;

import com.example.SayNoToHunger.Model.NewsItem;

public interface IAdminDashboardNewsItemSL {
	public String addNewsItem(NewsItem newsEntry);
	public String deleteNewsItem(String itemId);
	public LinkedList<NewsItem> getAllNewsItems();
}
