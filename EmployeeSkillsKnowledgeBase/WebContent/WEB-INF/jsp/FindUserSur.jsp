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
<title>List Users</title>

</head>
<body>
<table>
	<tr>
		<td><a href="index.html">Home Page</a></td>
		<td><a href="listUsers.html">List Users</a></td>
		<td><a href="FindUserSur.html">Find Users By Surname</a></td>
		<td><a href="FindUserId.html">Find Users By ID</a></td>
		<td><a href="saveUser.html">Save Users</a></td>
	</tr>
</table>

<c:forEach var="listVar" items="${userList}"> 
    <option value ="10"><c:out value="${listVar.username}"/><c:out value="${listVar.surname}"/><c:out value="${listVar.birthDate}"/></option>
</c:forEach>

</body>