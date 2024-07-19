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
@WebServlet("/edit")
public class EditProductServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		HttpSession hs = req.getSession(false);
		
		if(hs == null)
		{
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else
		{
			String pCode = req.getParameter("pcode");
			
			@SuppressWarnings("unchecked")
			ArrayList<ProductBean> al = (ArrayList<ProductBean>)hs.getAttribute("alist");
			
			Iterator<ProductBean> it = al.iterator();
			
			while(it.hasNext())
			{
				ProductBean pb = (ProductBean)it.next();
				
				if(pCode.equals(pb.getCode()))
				{
					req.setAttribute("pbean", pb);
					
					req.getRequestDispatcher("EditProduct.jsp").forward(req, res);
					
					break;
				}
			}
		}
	}
}

