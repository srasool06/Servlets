package com.nt.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.model.BookBean;
import com.nt.service.DbConnector;

public class MainServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{   //read form data
			String cat = req.getParameter("category");
			String checkAction=req.getParameter("source");
			
             //Create Service class obj  and call b.method
			DbConnector dbc = new DbConnector();
			ArrayList<BookBean> al = dbc.search(cat);

			
			req.setAttribute("list",al);
	

			String target;
			if(checkAction.equalsIgnoreCase("Html"))
					target = "HtmlPrint.jsp";
			else
					target = "ExcelScreen.jsp";

			RequestDispatcher rd  = null;
			rd = req.getRequestDispatcher(target);
			if(rd != null)
				rd.forward(req,res);
		} // try
		catch(Exception e)
		{
			e.printStackTrace();
		}
	} // doPost()
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		doPost(req,res);
	}
} // class