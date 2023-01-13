<%@page import="entities.User" %>

<nav class="standardNavBar">
	<ul class="leftNav">
		<li><a href="index.jsp">Home</a></li>
		<li><a href="#">Categories</a></li>
	</ul>
	<ul class="rightNav">
<%
	User user = (User)session.getAttribute("current_user");
	if(user != null){
%>
		<li><%= user.getName() %></li>
		<li><a href="#">Cart</a></li>
		<li><a href="LogoutServlet">Logout</a></li>

<% } %>

<% if(user == null){ %>	
		<li><a href="login.jsp">Login</a></li>
		<li><a href="register.jsp">Register</a></li>

<% } %>
</nav>
