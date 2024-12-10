<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Thank you for Ordering. </h3>
	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page import="controller.*" %>
	
	<p> <form action="tester" method="post"> 
	Enter your Billing: 
	<input type='text' name='def_billing' value='${sessionScope.def_billing }' /><br>
	Enter your Shipping: 
	<input type='text' name='def_shipping' value='${sessionScope.def_shipping }' /><br>
	
	<input type='submit' value='Confirm Order' /> 
		
</body>
</html>