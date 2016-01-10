<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UserList</title>
</head>
<body>
	<h1>I am Happy</h1>
	<table width="100%" cellspacing="1" cellpadding="1" border="0"
		class="listing_table">
		<tr>
			<th width="5%">S.No</th>
			<th width="5%">Id</th>
			<th width="17%">Name</th>
			<th width="21%">Email Address</th>
			<th width="23%">Gender</th>
			<th width="19%">Courses</th>
			<th width="20%">Tutor</th>
			<th width="15%">Action</th>
		</tr>
		<tbody id="employeeList">
			<c:forEach items="${empList}" var="item" varStatus="count">
				<tr>
					<td>${count.count}</td>
					<td>${item.id}</td>
					<td>${item.name}</td>
					<td>${item.email}</td>
					<td>${item.courses}</td>
					<td>${item.gender}</td>
					<td>${item.role}</td>
					<td align="center">
					<a href="<spring:url value="/employee/edit/${item.id}" />"><img
							border="0" alt="Edit" src="<spring:url value='/resource/images/edit.gif'/>"></a>&nbsp;&nbsp;
						<%-- <a onclick="return false;" data-action="delete-toggle"
						data-target="row-${count.count}" --%>
						<br>
						<a href="<spring:url value="/employee/delete/${item.id}" />"><img
							border="0" alt="Delete"
							src="<spring:url value="/resource/images/delete.png"/>"></a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

</body>
</html>