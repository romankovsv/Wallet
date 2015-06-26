<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Users</title>
    <style>
        <%@include file="style.css"%>
    </style>
</head>
<body>

<h1>USERS</h1>

<table border="1">
    <tr bordercolot="solid black">
        <th>ID</th>
        <th>Name</th>
        <th>Date of birth</th>
        <th>Date of registration</th>
        <th>SEX</th>
        <th>EMAIL</th>
    </tr>
    <c:forEach items="${list}" var ="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.date_of_birth}</td>
            <td>${user.date_of_registration}</td>
            <td>${user.sex}</td>
            <td>${user.email}</td>
            <td>
                <button>
                    <a href="delete-user?id=${user.id}">Delete</a>
                </button>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
