<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="helper.FactoryProvider" %>
<%@page import="org.hibernate.Session" %>
<%@page import="dao.ProductDao" %>
<%@page import="entities.Product" %>
<%@page import="java.util.List" %>
<%@page import="java.io.File" %>

<html>
<head>
<title>Homepage</title>

<%@include file="components/generic_css_js.jsp" %>

</head>

<body>
<%@include file="components/navbar.jsp" %>

<%
	ProductDao productDao = new ProductDao(FactoryProvider.getFactory());
	List<Product> products = productDao.getAllProducts();
	String applicationPath = getServletContext().getRealPath("asset");
%>

<div class="categoryButton">
	<button type="button" class="btn btn-outline-primary" id="all_product_button"><a href="index.jsp">All Products</a></button>
	<button type="button" class="btn btn-outline-success" id="cart_button">Cart</button>
</div>

<div class="container text-center" id="product_list">
  <div class="row row-cols-4">
	<% 
	String categoryId = request.getParameter("cid");
	
	for(Product p : products){
		int pid = p.getpId();
		String pName = p.getpName();
		String pImage = p.getpPhoto();
		double pCost = p.getPrice();
	%>  	
<div class="container text-center">
  <div class="row align-items-start">
    <div class="col">
		<div class="card" style="width: 80%;">
  			<img src="asset/productimages/<%=p.getpPhoto()%>" class="card-img-top" alt="...">
  			<div class="card-body">
    			<h5 class="card-title"><%=p.getpName() %></h5>
    			<h5 class="card-title">MRP: <%=p.getPrice() %></h5>
    			<p class="card-text">Description : <%=p.getpDesc()%></p>
    			<a href="#" class="btn btn-primary" onclick="addProduct('<%=pid%>','<%=pName%>','<%=pImage%>','<%=pCost%>')">Add to Cart</a>
  			</div>
		</div>
    </div>
    </div>
    </div>
    <%} %>
  </div>
</div>


<div id="cart_list" style="display:none; margin-top:20px">
<table id="cartTable" class="table" style="width:70%;margin:auto">
  <thead>
    <tr>
      <th scope="col"> </th>
      <th scope="col">Name</th>
      <th scope="col" >Quantity</th>
      <th scope="col">Price</th>
      <th scope="col" style="display:none"></th>
    </tr>
  </thead>
  <tbody id="populatedList">
  </tbody>
  
    <thead>
    <tr>
      <th scope="col"></th>
      <th scope="col" ></th>
      <th scope="col">Total</th>
      <th scope="col" id="cartTotalValue">0</th>
    </tr>
  </thead>
  <tbody>
  </tbody>
  
</table>

</div>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
<script src="components/homeButton.js"></script>
<script src="components/cart.js"></script>


</body>
</html>
