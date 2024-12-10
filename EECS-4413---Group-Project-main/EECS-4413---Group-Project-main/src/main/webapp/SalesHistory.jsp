<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sales History</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>

	<h2>Sales History</h2>
	
	<table>
		<tr>
			<th>Transaction Id</th>
			<th>Customer</th>
			<th>Item Name</th>
			<th>Item Id</th>
			<th>Quantity</th>
		</tr>
		
		<c:forEach items="${sales }" var="s">
			<tr>
				<td>${s.transactionId }</td>
				<td>${s.custName }</td>
				<td>${s.itemName }</td>
				<td>${s.itemId }</td>
				<td>${s.quantity }</td>
			</tr>
		</c:forEach>
	</table>
	
	<form method='get' action='AdminView'>
		<input type='hidden' name='username' value='${username }'>
		<input type='submit' value='Return to Admin Menu'>
	</form>
</body>
</html>