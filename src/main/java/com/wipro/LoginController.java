package com.wipro;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email=request.getParameter("email");
		String pass=request.getParameter("password");
		if (email.isEmpty() || pass.isEmpty()) {
			  RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			   out.println("<font color=red>Please fill all the fields</font>");
			   rd.include(request, response);
			  } else {
				
					try {
						Class.forName("com.mysql.jdbc.Driver");
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost/users", "root", "root");
			 
					PreparedStatement ps = c.prepareStatement("select Email,Password from users where Email=? and Password=?");
					ps.setString(1, email);
					ps.setString(2, pass);
			 
					ResultSet rs = ps.executeQuery();
					PrintWriter pout= response.getWriter();
					while (rs.next()) {
						pout.write("Login successfull...");
						RequestDispatcher rd = request.getRequestDispatcher("/success.jsp");
						rd.forward(request,response);
						return;
					}
					pout.write("Login fail...");
					 ps.close();
					 c.close();
					RequestDispatcher rd = request.getRequestDispatcher("/fail.jsp");
					rd.forward(request,response);
					return;
					} catch (Exception e) {
						e.printStackTrace();
					}
			  }
	}

}