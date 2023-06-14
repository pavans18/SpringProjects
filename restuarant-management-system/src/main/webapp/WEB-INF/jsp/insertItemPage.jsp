<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset = "utf-8">
<meta name ="viewport"
       content ="width= device-width, initial-scale=1, shrink-to-fit = no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>Add Item Page</title>
</head>
<body>
	<!-- Navbar -->

	<!-- Navbar -->
	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-primary">Add New Food Item</h4>

						<form th:action="@{/insert}" method="post">
							
							<div class="form-group">
								<label>Enter Item Number</label> <input type="text"
									class="form-control" name="itemNumber">
							</div>
							<div class="form-group">
								<label>Enter Item Name</label> <input type="text"
									class="form-control" name="itemName">
							</div>

							<div class="form-group">
								<label>Enter Item Cuisine</label> <input type="text"
									class="form-control" name="cuisine">
							</div>

							<div class="form-group">
								<label>Enter Item Price</label> <input type="text"
									class="form-control" name="price">
							</div>


							<div class="form-group">
								<label>The Item Availability</label> <input type="text"
									class="form-control" name="avialability">
							</div>

							<a href ="homePage" class="btn btn-primary btn-block">Submit</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>