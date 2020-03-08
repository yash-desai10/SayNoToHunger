package com.example.SayNoToHunger.DataLayer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.example.SayNoToHunger.DataLayer.InterfacesDL.IAdminDashboardNewsItemDL;
import com.example.SayNoToHunger.Model.NewsItem;

@Repository
public class AdminDashboardNewsItemDL implements IAdminDashboardNewsItemDL {
	private final String ADD_NEWS_ITEM = "{call [dbo].[sp_addNewsItem](?,?,?)}";
	private final String DELETE_NEWS_ITEM_BY_ID = "{call [dbo].[sp_deleteNewsItemById](?)}";
	private final String GET_ALL_NEWS_ITEMS = "{call [dbo].[sp_getAllNewsItems]}";
	private Connection connection;
	@Autowired
	private Environment applicationProperties;
	
	@Override
	public String addNewsItem(NewsItem newsEntry) {
		try {
			String connectionString = applicationProperties.getProperty("connectionString");
			connection =  DriverManager.getConnection(connectionString);
			CallableStatement statement = connection.prepareCall(ADD_NEWS_ITEM);
			statement.setString(1, newsEntry.getNewsId());
			statement.setString(2, newsEntry.getNewTitle());
			statement.setString(3, newsEntry.getNewLink());
			statement.executeUpdate();		
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"failure\"}";
		}
		return "{\"result\":\"success\"}";
	}

	@Override
	public String deleteNewsItem(String itemId) {
		try
		{
			String connectionString = applicationProperties.getProperty("connectionString");
			connection =  DriverManager.getConnection(connectionString);
			CallableStatement statement = connection.prepareCall(DELETE_NEWS_ITEM_BY_ID);
			statement.setString("ID", itemId);
			statement.execute();	
		}	
		catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"failure\"}";
		}
		return "{\"result\":\"success\"}";
	}
	
	@Override
	public LinkedList<NewsItem> getAllNewsItems() {
		LinkedList<NewsItem> newsItems = new LinkedList<NewsItem>();
		NewsItem newsItem;
		
		try {
			String connectionString = applicationProperties.getProperty("connectionString");
			connection =  DriverManager.getConnection(connectionString);
			CallableStatement statement = connection.prepareCall(GET_ALL_NEWS_ITEMS);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				newsItem = mapNewsItem(resultSet);
				if(null != newsItem) {
					newsItems.add(newsItem);
				}
			}
			
			return newsItems;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newsItems;
	}

	private NewsItem mapNewsItem(ResultSet resultSet) {
		NewsItem newsItem = new NewsItem();
		try {
			newsItem.setNewsId(resultSet.getString("ID"));
			newsItem.setNewTitle(resultSet.getString("TITLE"));
			newsItem.setNewLink(resultSet.getString("URL"));
			return newsItem;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
