<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Panel</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<p>Welcome ${username}</p>
	<p>Current Inventory</p>
	<table>
		<tr>
			<th>Name</th>
			<th>ID</th>
			<th>Description</th>
			<th>Category</th>
			<th>Brand</th>
			<th>Price</th>
			<th>Stock</th>
		</tr>
		
		<c:forEach items="${items }" var="i">
			<tr>
				<td>${i.name }</td>
				<td>${i.id }</td>
				<td>${i.description }</td>
				<td>${i.categoryName }</td>
				<td>${i.brand }</td>
				<td>${i.price }</td>
				<td>${i.stock }</td>
			</tr>
		</c:forEach>
	</table>
	
	<table>
		<tr>
			<td>
				<form method='get' action='InventoryManagement'>
					<input type='hidden' name='username' value="${username }">
					<input type='submit' value="Inventory Management">
				</form>
			</td>
			<td>
				<form method='get' action='SalesHistory'>
					<input type='hidden' name='username' value="${username }">
					<input type='submit' value="View Sales History">
				</form>
			</td>
			<td>
				<form method='get' action='ViewUsers'>
					<input type='hidden' name='username' value="${username }">
					<input type='hidden' name='remove' value='0'>
					<input type='hidden' name='addUser' value='0'>
					<input type='hidden' name='eFlag' value='0'>
					<input type='submit' value="Manage User Accounts">
				</form>
			</td>
			<td>
				<form method='get' action='LoginPage.jsp'>
					<input type='submit' value='Logout'>
				</form>
		</tr>
	</table>
</body>
</html>