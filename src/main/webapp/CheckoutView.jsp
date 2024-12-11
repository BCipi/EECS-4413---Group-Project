<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shipping and Billing Information</title>
</head>
<body>
	<h3>Enter Your Shipping and Billing Information. </h3>
	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page import="controller.*" %>
	
	<p> <form action="OrderConfirmation" method="post"> 
	Enter your Billing: 
	<input type='text' name='billing' value='${sessionScope.def_billing }' /><br>
	Enter your Shipping: 
	<input type='text' name='shipping' value='${sessionScope.def_shipping }' /><br>
	
	<input type='submit' value='Confirm Order' /> 
		
</body>
</html>