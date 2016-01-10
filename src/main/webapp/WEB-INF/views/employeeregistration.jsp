<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RegisterPage</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script type="text/javascript" src="js/site.js"></script>
  <script>
  $(function() {
    $( "#datepicker" ).datepicker({
      changeMonth: true,
      changeYear: true
    });
  });
  </script>
</head>
<body>
	<a href="hello?name=sabin">Click Here</a>
	<h2>Register</h2>
	<c:if test="${errMsg != null}">
 			${errMsg}
		</c:if>
	<form:form method="POST" modelAttribute="formRegister"
		action="register">
		<table>
			<tr>
				<td>Enter your name:</td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>Enter your mail:</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>Enter your DOB:</td>
				<td><form:input path="dob" id="datepicker" readonly="true"/></td>
				<td><form:errors path="dob" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>Enter your gender</td>
				<td><form:checkboxes path="gender" items="${genders}" /></td>
				<td><form:errors path="gender" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>Enter a password:</td>
				<td><form:password path="password" showPassword="true" /></td>
				<td><form:errors path="password" cssStyle="color: #ff0000;" /></td>
			<tr>
				<td>Confirm your password:</td>
				<td><form:password path="passwordConf" showPassword="true" /></td>
				<td><form:errors path="passwordConf" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>Choose the courses you like:</td>
				<td><form:checkboxes path="courses" items="${courses}" /></td>
				<td><form:errors path="courses" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>Role</td>
				<td><form:select path="role">
						<form:option value="" label="...." />
						<form:options items="${roles}" />
					</form:select></td>
				<td><form:errors path="role" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Submit"></td>
			</tr>
		</table>
		</form:form>
</body>
</html>