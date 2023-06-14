<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>Home page</title>
</head>
<body>



	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-primary">Edit Emp</h4>

						<form th:action="@{/update}" method="post" th:object="${fooditem}">

							<input type="hidden" th:value="${fooditem.itemNumber}"
								name="itemNumber">

							<div class="form-group">
								<label>Item Number</label> <input type="text"
									class="form-control" name="itemNumber"
									th:value="${fooditem.itemNumber}">
							</div>

							<div class="form-group">
								<label>Item Name</label> <input type="text" class="form-control"
									name="itemName" th:value="${fooditem.itemName}">
							</div>

							<div class="form-group">
								<label>Item Cuisine</label> <input type="email"
									class="form-control" name="cuisine"
									th:value="${fooditem.cuisine}">
							</div>


							<div class="form-group">
								<label>Enter New Price</label> <input type="number"
									class="form-control" name="price" th:value="${fooditem.price}">
							</div>


							<div class="form-group">
								<label>Enter New Availability Status</label> <input
									type="number" class="form-control" name="availability"
									th:value="${fooditem.availability}">
							</div>

							<button class="btn btn-primary btn-block">Submit</button>

						</form>
					</div>
				</div>

			</div>
		</div>

	</div>



	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>