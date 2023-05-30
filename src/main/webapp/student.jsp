<%@ page import="java.util.List" %>
<%@ page import="com.example.demo_duc.Students" %><%--
  Created by IntelliJ IDEA.
  User: Duc
  Date: 25/05/2023
  Time: 11:29 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="CreateServlet">Creat</a>
<br>
    <c:forEach items="${arr}" var="i">
        <p><c:out value="${i}"></c:out></p><br>
        <a href="/UpdateServlet?id=${i.id}">Update</a> <br>
        <a href="/Delete?deleteid=${i.id}">Delete</a>
    </c:forEach>
</body>
</html>
