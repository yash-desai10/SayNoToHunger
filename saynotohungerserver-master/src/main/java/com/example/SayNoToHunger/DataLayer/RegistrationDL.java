package com.example.SayNoToHunger.DataLayer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.example.SayNoToHunger.DataLayer.InterfacesDL.IRegistrationDL;
import com.example.SayNoToHunger.Model.CurrentUser;
import com.example.SayNoToHunger.Model.UserModel;

@Service
public class RegistrationDL implements IRegistrationDL
{
	
	@Autowired
	public Environment applicationProperties;

	@Override
	public boolean AddUser(UserModel usermodel) 
	{
		Connection connection=null;
		CallableStatement callStatement=null;
		String connectionURL=applicationProperties.getProperty("connectionString");
		
		try 
		{
			System.out.println("connected");
			connection = DriverManager.getConnection(connectionURL);
			callStatement = connection.prepareCall("{call [dbo].[sp_registerUser](?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			callStatement.setString("email", usermodel.getEmail());
			callStatement.setString("pwd", usermodel.getPassword());
			callStatement.setLong("phone", 9024);
			callStatement.setString("role", usermodel.getRole()	);
			callStatement.setString("userType", usermodel.getUsertype());
			callStatement.setString("firstname", usermodel.getFirstname());
			callStatement.setString("lastname", usermodel.getLastname());
			callStatement.setString("addressline1", usermodel.getAddress1());
			callStatement.setString("addressline2", usermodel.getAddress2());
			callStatement.setString("city", "Halifax");
			callStatement.setString("province", "Nova Scotia");
			callStatement.setString("country", "Canada");
			callStatement.setString("about", "");
			callStatement.setString("orgName", usermodel.getOrgname());
			callStatement.setString("orgCategory", usermodel.getOrgcategory());
			callStatement.execute();
		}  
		catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
		finally{
			connection = null;
		}
		return true;
		
	}

	public CurrentUser LoginUser(UserModel usermodel){
		CurrentUser user = null;
		Connection connection=null;
		CallableStatement statement=null;
		String connectionURL=applicationProperties.getProperty("connectionString");
		try 
		{
			connection = DriverManager.getConnection(connectionURL);
			statement = connection.prepareCall("{call [dbo].[sp_loginUser](?,?)}");
			statement.setString("email", usermodel.getEmail());
			statement.setString("pwd", usermodel.getPassword());
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				user =  new CurrentUser();
				user.email = resultSet.getString("email");
				user.phone = resultSet.getInt("phone");
				user.userId = resultSet.getInt("id");
				user.role = resultSet.getString("role");
				user.userType = resultSet.getString("usertype");
				user.username = resultSet.getString("username");
			}
		}  
		catch (Exception exception) {
			exception.printStackTrace();
			return user;
		}
		finally{
			connection = null;
		}
		return user;
	}
}
