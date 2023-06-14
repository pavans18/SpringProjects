<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.example.entity.FoodItem" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
</head>
<body class="container">

   <p class="text-center" >Le Gourmet Food Center</p>
  	<hr/>
  	<div class ="text-center">
	<a href="insertItemPage" class="btn btn-warning">Create New Food Item</a>
	</div>
<div class = "container p-5">
	<table class = "table table-striped" border = "1">
	<thead class = "bg-info text-white">
		<tr>
			<th scope = "col">Number</th>
			<th scope = "col">Name</th>
			<th scope = "col">Type</th>
			<th scope = "col">Price</th>
			<th scope = "col">Availability</th>
			<th scope = "col">Actions</th>
		</tr>
		</thead>
		<tbody>
			<c:forEach var = "item"  items="${fooditems}" >
				<td>${fooditems.itemNumber}</td>
				<td>${fooditems.itemName}</td>
				<td>${fooditems.cuisine}</td>
				<td>${fooditems.price}</td>
				<td>${fooditems.availability}</td>
				<td><a href= "/edit = ${items.itemNumber}" class = "btn btn-sm btn-primary">Edit</a> &nbsp; &nbsp; <a 
							href= "/delete = ${items.itemNumber}" class ="btn btn-sm btn-danger">Delete</a>
				</td>
				</c:forEach>
				
			
			
		
		</tbody>
		</table>
		</div>
</body>
</html>