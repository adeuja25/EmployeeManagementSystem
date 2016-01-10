<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EMS</title>
</head>
<body>
	<center>
		<h2>Hello World</h2>
		<c:choose>
			<c:when test="${message eq null}">
				<h1>Add Role</h1>
				<form:form method="POST" modelAttribute="addRole" action="addRole">
					<table>
						<tr>
							<td>Enter your Role:</td>
							<td><form:input path="newRole" /></td>
							<td><form:errors path="newRole" cssStyle="color: #ff0000;" /></td>
						</tr>
						<tr>
							<td><input type="submit" name="submit" value="Submit"></td>
						</tr>
					</table>
				</form:form>
				<br />
			</c:when>
			<c:otherwise>
				<h2>${message}${name}</h2>
				<a href="register">Register</a>
			</c:otherwise>
		</c:choose>
	</center>
</body>
</html>