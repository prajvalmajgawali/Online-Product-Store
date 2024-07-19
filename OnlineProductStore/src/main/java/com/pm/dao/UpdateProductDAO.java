package com.pm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.pm.bean.ProductBean;
import com.pm.dbconncection.DBConnection;

public class UpdateProductDAO 
{
	public int k=0;
	
	public int updateProduct(ProductBean pb)
	{
		try
		{
			Connection con = DBConnection.getCon();
			
			PreparedStatement ps = con.prepareStatement("Update product50 set price=?,qty=? where code=?");
			
			ps.setFloat(1, pb.getPrice());
			ps.setInt(2, pb.getQty());
			ps.setString(3, pb.getCode());
			
			k = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	 return k;
	}
}
