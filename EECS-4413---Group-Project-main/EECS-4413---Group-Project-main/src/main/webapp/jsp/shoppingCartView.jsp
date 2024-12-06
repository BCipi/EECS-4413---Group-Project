<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart</title>
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<h1>Shopping Cart</h1>
	<table border='1' cellpadding='6'>
		<tr>
			<th>Item Name</th>
			<th>Price Per Item</th>
			<th>Quantity</th>
			<th>Increase/Decrease Quantity</th>
			<th>Remove Item</th>
		</tr>

		<tr>
			<td>The Hunger Games</td>
			<td>20.99</td>
			<td>1</td>
			<td>
				<table>
					<tr>
						<td>
							<form method='get'>
								<input type='hidden' name='itemID' value='1000' /> <input
									type='hidden' name='action' value='increase' /> <input
									type='submit' value='Increase' />
							</form>
						</td>
						<td>
							<form>
								<input type='hidden' name='itemID' value='1000' /> <input
									type='hidden' name='action' value='decrease' /> <input
									type='submit' value='Decrease' />
							</form>
						</td>

					</tr>
				</table>
			</td>
			<td>
				<form>
					<input type='hidden' name='itemID' value='1000' /> <input
						type='hidden' name='action' value='remove' /> <input
						type='submit' value='Remove' />
				</form>
			</td>

		</tr>

		<tr>
			<td colspan='5'>Total Price: $20.99</td>

		</tr>


	</table>
	<br>
	<form action='CheckoutServlet' method='get'>

		<input type='submit' value='Go to Checkout' />
	</form>
	<br>
	<a href="index.html">Keep Shopping</a>

</body>
</html>