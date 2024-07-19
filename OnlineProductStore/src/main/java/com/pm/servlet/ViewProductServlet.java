package com.pm.servlet;

import java.io.IOException;
import java.util.ArrayList;

import com.pm.bean.ProductBean;
import com.pm.dao.ViewProductDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewProductServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException
	{
		HttpSession hp = req.getSession(false);
		
		if(hp == null)
		{
			req.setAttribute("msg", "Session Expaired...<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else
		{
			ArrayList<ProductBean> al = new ViewProductDAO().retrive();
			
			hp.setAttribute("alist", al);
			
			req.getRequestDispatcher("View.jsp").forward(req, res);
		}
	}
}
