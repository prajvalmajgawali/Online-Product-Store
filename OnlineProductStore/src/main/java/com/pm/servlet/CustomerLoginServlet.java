package com.pm.servlet;

import java.io.IOException;

import com.pm.bean.CustomerBean;
import com.pm.dao.CustomerLoginDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/customer")
public class CustomerLoginServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException ,IOException
	{
		String uName = req.getParameter("uname");
		String pWord = req.getParameter("pword");
		
		CustomerBean cb = new CustomerLoginDAO().login(uName, pWord);
		
		if(cb == null)
		{
			req.setAttribute("msg", "Invalid UserName and Password..<br>");
			req.getRequestDispatcher("CustomerMsg.jsp").forward(req, res);
		}
		else
		{
			HttpSession hs = req.getSession();
			
			hs.setAttribute("cbean", cb);
			
			req.getRequestDispatcher("Customer.jsp").forward(req, res);
		}
	}
}
