<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="helper.FactoryProvider" %>
<%@page import="org.hibernate.Session" %>

<html>
<head>
<title>User Registration</title>

<%@include file="components/generic_css_js.jsp" %>
</head>

<body>
<%@include file="components/navbar.jsp" %>

	<div class="customMessage">
		<%@include file="components/message.jsp" %>
	</div>

<div class="userRegistration">
	<h2>Enter User Details</h2>
	<form action="RegisterServlet" method="post" class="userRegistration">
 		<label for="user_name">Full Name</label><br>
  		<input type="text" id="user_name" name="user_name"><br>
  		<label for="user_phone">Phone Number</label><br>
  		<input type="number" id="user_phone" name="user_phone"><br>
  		<label for="user_email">Email</label><br>
  		<input type="email" id="user_email" name="user_email"><br>
  		<label for="user_password">Password</label><br>
  		<input type="password" id="user_password" name="user_password"><br>
  		<label for="user_address">Address</label><br>
  		<textarea id="user_address" name="user_address" placeholder="Enter Address"></textarea><br><br>
  		<select class="form-select form-select-sm" aria-label=".form-select-sm example">
  			<option selected>Open this select menu</option>
  			<option id="user_type" name="user_type" value="admin">Admin</option>
  			<option id="user_type" name="user_type" value="normal">Normal</option>
		</select>
  		<button type="submit">Create Account</button>
</form>
</div>

</body>
</html>
