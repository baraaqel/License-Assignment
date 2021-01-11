<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New License</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">

</head>
<body>

<h1>New License</h1>
<form:form action="/licenses/new" method="post" modelAttribute="license">
    <p>
        <form:label path="person">Person :</form:label>
        <form:errors path="person"/>
        <form:select path="person">
       		<c:forEach items="${persons}" var="p">
       			<form:option  value="${p.id}">${p.firstName} ${p.lastName }</form:option>
        	</c:forEach>
        </form:select>
    </p>
    <p>
        <form:label path="state">State :</form:label>
        <form:errors path="state"/>
        <form:input path="state"/>
    </p>
    <p>
        <form:label path="expirationDate">Expiration Date :</form:label>
        <form:errors path="expirationDate"/>
        <form:input type ="date" path="expirationDate"/>
    </p>
    <input type="submit" value="Create"/>
</form:form>    

</body>
</html>