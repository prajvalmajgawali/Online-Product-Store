package com.pm.servlet;

import java.io.IOException;

import com.pm.bean.UserBean;
import com.pm.dao.AdminDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/admin")
public class AdminServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException
	{
		String uName = req.getParameter("uname");
		String pWord = req.getParameter("pword");
		
		UserBean ub = new AdminDAO().login(uName, pWord);
		
		if(ub == null)
		{
			req.setAttribute("msg", "Invalid User Name And Pasword...<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else
		{
			HttpSession hs = req.getSession();
			
			hs.setAttribute("ubean", ub);
			
			req.getRequestDispatcher("Admin.jsp").forward(req, res);
		}
	}
}
