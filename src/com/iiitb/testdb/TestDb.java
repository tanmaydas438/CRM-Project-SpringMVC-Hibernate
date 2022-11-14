package com.iiitb.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDb
 */
@WebServlet(name = "TestDbServlet", urlPatterns = { "/TestDbServlet" })
public class TestDb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String uname="springstudent";
		String pass="springstudent";
		String driver="com.mysql.jdbc.Driver";
		try {
			PrintWriter pw=response.getWriter();
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,uname,pass);
			pw.write("Successfull");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
