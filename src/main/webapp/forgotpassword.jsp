<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ForgotPassword</title>
<link href="/resources/css/bookstore_styles.css" rel="stylesheet">
</head>
<body>
	<h1>ForgotPassword</h1>	
	<form action="ForgotPasswordController" method="post">
	  <div class="container">
	    <label><b>Email</b></label>
	    <input type="text" placeholder="Enter Email" name="email" required>
	
	    <label><b>New Password</b></label>
	    <input type="password" placeholder="Enter Password" name="newpassword" required>
	    
	    <label><b>Confirm Password</b></label>
	    <input type="password" placeholder="Enter ConfirmPassword" name="confirmpassword" required>
	    
	        
	    <button type="submit">Submit</button>
	  </div>
</form>
</body>
</html>