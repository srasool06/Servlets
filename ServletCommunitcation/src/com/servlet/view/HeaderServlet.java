package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class HeaderServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		// add header content
		
		out.println("<marquee><h1>Rayalaseema University</h1></marquee>");
		
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
