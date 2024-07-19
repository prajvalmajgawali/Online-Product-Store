package com.pm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.pm.dbconncection.DBConnection;

public class PaymentDAO 
{
	public int k = 0;
	
	public int payment(String pCode,int qty)
	{
		try
		{
			Connection con = DBConnection.getCon();
			
			PreparedStatement ps = con.prepareStatement("update product50 set qty=qty-? where code=?");
			
			ps.setInt(1, qty);
			ps.setString(2, pCode);
			
			k = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return k;
	}
}
