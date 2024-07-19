package com.pm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pm.bean.CustomerBean;
import com.pm.dbconncection.DBConnection;

public class CustomerLoginDAO 
{
	public CustomerBean cb = null;
	
	public CustomerBean login(String uName,String pWord)
	{
		try
		{
			Connection con = DBConnection.getCon();
			
			PreparedStatement ps = con.prepareStatement("Select * from customer50 where uname=? and pword=?");
			
			ps.setString(1, uName);
			ps.setString(2, pWord);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				cb = new CustomerBean();
				
				cb.setuName(rs.getString(1));
				cb.setpWord(rs.getString(2));
				cb.setfName(rs.getString(3));
				cb.setlName(rs.getString(4));
				cb.setAddrs(rs.getString(5));
				cb.setMid(rs.getString(6));
				cb.setPhno(Long.parseLong(rs.getString(7)));
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return cb;
	}
}
