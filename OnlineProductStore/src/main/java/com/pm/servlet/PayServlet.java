package com.pm.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.pm.bean.ProductBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/pay")
public class PayServlet  extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		HttpSession hs = req.getSession(false);
		
		if(hs == null)
		{
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("CustomerMsg.jsp").forward(req, res);
		}
		else
		{
			String pCode = req.getParameter("pcode");
			String qty = req.getParameter("qty");
			
//			ProductBean p = (ProductBean) req.getAttribute("pbean");
//			if(p.getQty()>Integer.parseInt(qty))
//			{
//				req.setAttribute("msg", "Product Out of stock");
//				req.getRequestDispatcher("BuyProduct.jsp").forward(req, res);
//			}
//			else
			req.setAttribute("int", qty);
			
			
			@SuppressWarnings("unchecked")
			ArrayList<ProductBean> al = (ArrayList<ProductBean>)hs.getAttribute("alist");
			
			Iterator<ProductBean> it = al.iterator();
			
			while(it.hasNext())
			{
				ProductBean pb = (ProductBean)it.next();
				
				if(pCode.equals(pb.getCode()))
				{
					req.setAttribute("pbean", pb);
					
					req.getRequestDispatcher("Pay.jsp").forward(req, res);
					
					break;
				}
			}
		}
	}
}