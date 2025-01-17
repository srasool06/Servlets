package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class ConnPoolServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 //get PrintWriter 
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data
		String table=req.getParameter("table");
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try{
		// get con obj from jdbc con  pool
		 con=makeConnection();
		//create Statement obj
		 st=con.createStatement();
		//send and execute SQL Query in DB s/w
		 rs=st.executeQuery("select  *  from  "+table);
		//get ResultSet MetaData obj
		ResultSetMetaData rsmd=rs.getMetaData();
		//print col name
		int colCount=rsmd.getColumnCount();
		pw.println("<table border='1'>");
		pw.println("<tr>");
		 for(int i=1;i<=colCount;++i){
			 pw.println("<th>"+rsmd.getColumnLabel(i)+"</th>");
		 }//for
		 pw.println("</tr>");
		 //print col values
		 while(rs.next()){
		  pw.println("<tr>");	 
  			 for(int i=1;i<=colCount;++i){
  				 pw.println("<td>"+rs.getString(i)+"</td>");
  			 }//for
  		  pw.println("</tr>");
		 }//while
		 
		}//try
		catch(SQLException se){
			pw.println("<h1 style='color:red'>Table not found </h1>");
		}
		catch(Exception e){
			pw.println("<h1 style='color:red'>Unknown problem </h1>");
		}
		finally{
			try{
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if(st!=null)
					st.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if(con!=null)
					con.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
		}//finally
		pw.println("<a href='index.html'>view another table </a>");
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}//doPost(-,-)
	
	private Connection makeConnection(){
		try{
			// Establish the connection with Jndi Registry (create InitialContext obj)
			InitialContext ic=new InitialContext();
			//Get DataSource obj ref from jndi registry
			DataSource ds=(DataSource)ic.lookup("java:/comp/env/DsJndi");
			//get jdbc con obj from jdbc con pool
			Connection con=ds.getConnection();
			return con;
		}
		catch(Exception e){
			return null;
		}
	}//method

}//class
