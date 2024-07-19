package com.pm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.pm.bean.ProductBean;
import com.pm.dbconncection.DBConnection;

public class ProductDAO
{
	int k;
	
	public int addProduct(ProductBean pb)
	{
		try
		{
			Connection con = DBConnection.getCon();
					
			PreparedStatement ps = con.prepareStatement("Insert into product50 values(?,?,?,?)");
			
			ps.setString(1, pb.getCode());
			ps.setString(2, pb.getName());
			ps.setFloat(3, pb.getPrice());
			ps.setInt(4, pb.getQty());
			
			k = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}
}
