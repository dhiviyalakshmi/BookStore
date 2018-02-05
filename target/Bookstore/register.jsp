<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<link href="/resources/css/bookstore_styles.css" rel="stylesheet">
</head>
<body>
	<h1>Registration Form</h1>
	<form action="RegistrationController" method="post">
	  <div class="container">
	    
		<label><b>First Name</b></label>
	    <input type="password" placeholder="Enter First Name" name="firstname" required>
	    
	    <label><b>Last Name</b></label>
	    <input type="password" placeholder="Enter Lastt Name" name="lastname" required>
	    
	    <label><b>Password</b></label>
	    <input type="password" placeholder="Enter Password" name="pass" required>
	    
	    <label><b>Confirm Password</b></label>
	    <input type="password" placeholder="Enter ConfirmPassword" name="confirmpass" required>
	    
	    <label><b>Email</b></label>
	    <input type="text" placeholder="Enter Email" name="email" required>        
	    <button type="submit">Register</button>
	  </div>
</form>
</body>
</html>