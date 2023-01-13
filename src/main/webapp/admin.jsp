<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entities.User" %>
<%@page import="helper.FactoryProvider" %>
<%@page import="java.util.List" %>



<%
	User adminUser = (User)session.getAttribute("current_user");
	if(adminUser == null || adminUser.getUserType().equals("normal")){
		session.setAttribute("message","You are not allowed to access this page");
		response.sendRedirect("login.jsp");
		return;
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
<%@include file="components/generic_css_js.jsp" %>

</head>
<body>
<%@include file="components/navbar.jsp" %>

<div class="customMessage">
		<%@include file="components/message.jsp" %>
	</div>

	<div class="container">
		
		<div class="card">
			<div class="cardTitle"> <h2>Products</h2>
			</div>
			<div class="cardDetail">
				<div class="cardImage"> <img align="middle" style="max-width:150px" src="asset/product.png" >
				</div>
				<h3>Number Tags</h3>
				<div class="addNew">
					<img data-bs-toggle="modal" data-bs-target="#addProduct" style="max-width:50px" src="asset/add.png" >
					<h3>Add New Product</h3>
				</div>
				
			</div>
		</div>
	</div>
	

<!-- Product Modal -->
<div class="modal fade" id="addProduct" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
         <form action="AddPoductServlet" method="post" class="AddPoductServlet" enctype="multipart/form-data">
          <div class="mb-3">
            <label for="product_name" class="col-form-label">Product Name:</label>
            <input type="text" class="form-control" id="product_name" name="product_name" required>
          </div>
          <div class="mb-3">
            <label for="product_price" class="col-form-label">Price:</label>
            <input type="number" class="form-control" id="product_price" name="product_price" required>
          </div>
          <div class="mb-3">
            <label for="product_qty" class="col-form-label">Quantity:</label>
            <input type="number" class="form-control" id="product_qty" name="product_qty" required>
          </div>

          <br>
          <div>
          	<input type="file" name="productImage">
          </div>
          <div class="mb-3">
            <label for="product_description" class="col-form-label">Description:</label>
            <textarea class="form-control" id="product_description"  name="product_description"></textarea>
          </div>
          <button type="submit" class="btn btn-primary">Add</button>
        </form>
      </div>
    </div>
  </div>
</div>






</body>
</html>