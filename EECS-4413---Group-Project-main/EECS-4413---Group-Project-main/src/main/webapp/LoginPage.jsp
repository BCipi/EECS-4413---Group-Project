<%@ page language="java" contentType='text/html; charset=UTF-8' pageEncoding="UTF-8"%>
<html>
	<head>
		<title>Login Page</title>
		<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
	</head>
	<body>
		<c:choose>
			<c:when test="${requestScope.returnValue == 1}">
				<p>Account Created Successfully</p>
			</c:when>
			<c:when test="${requestScope.returnValue == 2 }">
				<p>Username is already in use. Please Try Again</p>
			</c:when>
			<c:when test="${requestScope.returnValue == 3 }">
				<p>Error Creating Account. Please Try Again</p>
			</c:when>
			<c:when test="${requestScope.returnValue == 4 }">
				<p>Login Failed. Please Try Again</p>
			</c:when>
			<c:otherwise>
				<p>Welcome!</p>
			</c:otherwise>
		</c:choose>
		<h2>Login:</h2>
		<form method='get' action='AttemptLogin'>
			<p>Username: <input tpye='text' name='username'></p>
			<p>Password: <input type='text' name='password'></p>
			<input type='submit' value='Login'>
		</form>
		<a href='Register.html'>Create an Account</a>
	</body>
</html>