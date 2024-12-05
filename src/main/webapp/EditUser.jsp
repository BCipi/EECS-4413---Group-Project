<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin - Edit User</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<h2>Modify User: ${userAccount.username }</h2>
	<form method='get' action='ViewUsers'>
		<p>Name: <input type='text' name='newName' value='${userAccount.name }'></p>
		<p>Username: <input type='text' name='newUsername' value='${userAccount.username }'>
		<p>Password: <input type='text' name='newPassword' value = '${userAccount.password }'></p>
		<p>Shipping Address: <input type='text' name='newShip' value='${userAccount.shipAddress }'>
		<p>Billing Address: <input type='text' name='newBill' value='${userAccount.billingAddress }'>
		<p>Credit Card: <input type='text' name='newCC' value='${userAccount.creditCard }'></p>
		<p>Privilege: <select name='newPriv'>
			<option value="1">User</option>
			<option value="2">Admin</option>
		</select></p>
		<input type='hidden' name='eFlag' value='1'>
		<input type='hidden' name='addUser' value='0'>
		<input type='hidden' name='remove' value='0'>
		<input type='hidden' name='username' value='${userAccount.username }'>
		<input type='submit' value='Update Information'>
	</form>
</body>
</html>