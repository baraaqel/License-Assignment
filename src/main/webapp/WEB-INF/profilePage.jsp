<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Page</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">

</head>
<body>
<h1>${person.firstName } ${person.lastName }</h1>
<p>License Number <c:out value="${person.license.getNumberAsString()}"/></p>
<p>State <c:out value="${person.license.state}"/></p>
<p>Expiration Date <c:out value="${person.license.getExpirationDateFormat()}"/></p>


</body>
</html>