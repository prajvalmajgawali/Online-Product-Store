package com.pm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.pm.bean.ProductBean;
import com.pm.dbconncection.DBConnection;

public class DeleteProductDAO 
{
	public int k = 0;
	
	public int delete(ProductBean pb)
	{
		try 
		{
			Connection con = DBConnection.getCon();
			
			PreparedStatement ps = con.prepareStatement("Delete From product50 where code=?");
			
			ps.setString(1, pb.getCode());
			
			k = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return k;
	}
}
