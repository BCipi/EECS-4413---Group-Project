<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage User Accounts</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<h2>Manage User Accounts</h2>
	
	<table>
		<tr>
			<th>Name</th>
			<th>Username</th>
			<th>Password</th>
			<th>Credit Card</th>
			<th>Shipping Address</th>
			<th>Billing Address</th>
			<th>Privilege Level</th>
			<th>Edit User</th>
			<th>Remove User</th>
		</tr>
		
		<c:forEach items="${users }" var="a">
			<tr>
				<td>${a.name }</td>
				<td>${a.username }</td>
				<td>${a.password }</td>
				<td>${a.creditCard }</td>
				<td>${a.shipAddress }</td>
				<td>${a.billingAddress }</td>
				<td>${a.priv }</td>
				<td>
					<form method='get' action ='EditUser'>
						<input type='hidden' name='eUser' value='${a.username }'>
						<input type='hidden' name='username' value='${param.username}'>
						<input type='submit' value='Edit User'>
					</form>
				</td>
				<td>
					<form method='get' action="ViewUsers">
						<input type='hidden' name='remove' value='1'>
						<input type='hidden' name='addUser' value='0'>
						<input type='hidden' name='rUsername' value="${a.username}">
						<input type='hidden' name='username' value="${param.username }">
						<input type='submit' value='Remove Account'>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<form method='get' action='AdminAddUser.html'>
		<input type='hidden' name='username' value='${username }'>
		<input type='submit' value='Create New Account'>
	</form>
	<form method='get' action='AdminView'>
		<input type='hidden' name='username' value='${username }'>
		<input type='submit' value='Return to Admin Menu'>
	</form>
</body>
</html>