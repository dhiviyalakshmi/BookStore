package com.wipro;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegistrationController extends HttpServlet {

 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
  response.setContentType("text/html");
  PrintWriter out = response.getWriter();
  String fname = request.getParameter("firstname");
  String lname = request.getParameter("lastname");
  String pass = request.getParameter("pass");
  String confirmpass = request.getParameter("confirmpass");
  String email = request.getParameter("email");
 

  if (fname.isEmpty() || lname.isEmpty() || pass.isEmpty() || confirmpass.isEmpty() || email.isEmpty()) {
	   RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
	   out.println("<font color=red>Please fill all the fields</font>");
	   rd.include(request, response);
  } 
  else {
	   PrintWriter pout= response.getWriter();
	   if(pass.equals(confirmpass)) {
	   try {
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/users", "root", "root"); 
	
	    String query = "insert into users (FirstName, LastName, Password, Email) values(?,?,?,?)";
	
	    PreparedStatement ps = con.prepareStatement(query);
	
	    ps.setString(1, fname);
	    ps.setString(2, lname);
	    ps.setString(3, pass);
	    ps.setString(4, email);
	  
	    int check=ps.executeUpdate(); 
	    if(check>0){   
		    pout.write("Successfuly registered...");
		    RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		    rd.forward(request, response);
	    }
	    else
	    {
	  	  RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
	  	  out.println("<font color=red>Registration fail</font>");
	  	  rd.include(request, response);
	    }
	    ps.close();
	    con.close();
	   } catch (Exception e) {
	    e.printStackTrace();
	   }
	  }
	  
	  else
	  {
		  out.println("<font color=red>Password and Confirm Password doen't matches</font>");
		  RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
		  rd.include(request, response);
	  }
 }
 }
}
