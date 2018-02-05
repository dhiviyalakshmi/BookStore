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


public class ForgotPasswordController extends HttpServlet {

 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
  response.setContentType("text/html");
  PrintWriter out = response.getWriter();
  String newpass = request.getParameter("newpassword");
  String confirmpass = request.getParameter("confirmpassword");
  String email = request.getParameter("email");
 

  if (newpass.isEmpty() || confirmpass.isEmpty() || email.isEmpty()) {
   out.println("<font color=red>Please fill all the fields</font>");
  } else {
   if(newpass.equals(confirmpass)) {
   try {
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/users", "root", "root"); 
    String query = "update users set Password= ? where Email= ?";
    PreparedStatement ps = con.prepareStatement(query);

    ps.setString(1, newpass);
    ps.setString(2, email);
  
    ps.executeUpdate(); 
    System.out.println("successfuly updated");
    ps.close();
    con.close();
   } catch (Exception e) {
    e.printStackTrace();
   }
   RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
   out.write("password updated");
   rd.forward(request, response);
  }
  
  else
  {
	  out.println("<font color=red>Password and Confirm Password doen't matches</font>");
  }
 }
 }
}
