<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"     uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Employees</title>

</head>
<body>
<table>
	<tr>
		<td><a href="index.html">Home Page</a></td>
		<td><a href="listEmployees.html">List Employees</a></td>
		<td><a href="FindEmployeeSur.html">Find Employees By Surname</a></td>
		<td><a href="FindEmployeeId.html">Find Employees By ID</a></td>
		<td><a href="saveEmployee.html">Save Employees</a></td>
	</tr>
</table>

<c:forEach var="listVar" items="${employeeList}"> 
    <option value ="10"><c:out value="${listVar.name}"/><c:out value="${listVar.surname}"/><c:out value="${listVar.birthDate}"/></option>
</c:forEach>

</body>