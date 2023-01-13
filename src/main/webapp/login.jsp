<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="components/generic_css_js.jsp" %>

</head>
<body>


	
<div class="userRegistration">
	<div class="customMessage">
		<%@include file="components/message.jsp" %>
	</div>
	<h2>Enter User Details</h2>
	<form action="LoginServlet" method="post" class="userRegistration">
  		<label for="user_email">Email</label><br>
  		<input type="email" id="user_email" name="user_email" required><br>
  		<label for="user_password">Password</label><br>
  		<input type="password" id="user_password" name="user_password" required><br>
  		<button type="submit">Login</button>
</form>
</div>

</body>
</html>