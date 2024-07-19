package com.pm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.pm.bean.ProductBean;
import com.pm.dbconncection.DBConnection;

public class ViewProductDAO 
{
	public ArrayList<ProductBean> al = new ArrayList<ProductBean>();
	
	public ArrayList<ProductBean> retrive()
	{
		try
		{
			Connection con = DBConnection.getCon();
			
			PreparedStatement ps = con.prepareStatement("Select * from product50");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				ProductBean pb = new ProductBean();
				
				pb.setCode(rs.getString(1));
				pb.setName(rs.getString(2));
				pb.setPrice(rs.getFloat(3));
				pb.setQty(rs.getInt(4));
				
				al.add(pb);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return al;
	}
}
