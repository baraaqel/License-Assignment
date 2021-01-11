<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Person</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">

</head>
<body>

<h1>New Person</h1>
<form:form action="/persons/new" method="post" modelAttribute="person">
    <p>
        <form:label path="firstName">First Name :</form:label>
        <form:errors path="firstName"/>
        <form:input path="firstName"/>
    </p>
    <p>
        <form:label path="lastName">Last Name</form:label>
        <form:errors path="lastName"/>
        <form:input path="lastName"/>
    </p>
    <input type="submit" value="Create"/>
</form:form>    

</body>
</html>