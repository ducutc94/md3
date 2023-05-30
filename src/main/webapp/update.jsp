<%--
  Created by IntelliJ IDEA.
  User: Duc
  Date: 26/05/2023
  Time: 8:51 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/Update" method="post">
    <label >Creat</label>
    <input type="text"  size="15"  value="${student.id}" name="id">
    <input type="text" size="15" value="${student.name}" name="name">
    <select class="classname" id="classname" name="classname">
        <option selected>Class</option>
        <c:forEach items="${arrayList}" var="i">
            <option value="${i.getName()}"> ${i.getName()} </option>
        </c:forEach>

    </select>
    <div><button type="submit" >Update</button></div>
    <br>
</form>
</body>
</html>
