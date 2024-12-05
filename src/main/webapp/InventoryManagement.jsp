<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inventory Management</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>

	<h2>Inventory Management</h2>
	<table>
		<tr>
			<th>Item Name</th>
			<th>Item ID</th>
			<th>Current Quantity</th>
			<th>New Quantity</th>
		</tr>
		<c:forEach items="${Items }" var="i">
			<tr>
				<td>${i.name }</td>
				<td>${i.id }</td>
				<td>${i.stock }</td>
				<td>
					<form method='get' action='InventoryManagement'>
						<input type='text' name='newStock' value="${i.stock }">
						<input type='hidden' name='username' value='${param.username }'>
						<input type='hidden' name='update' value='1'>
						<input type='hidden' name='newId' value='${i.id }'>
						<input type='submit' value="Update Qty">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<form method='get' action='AdminView'>
		
		<input type='hidden' name='username' value="${username }">
		<input type='submit' value='Back to Admin Menu'>
	
	</form>
</body>
</html>