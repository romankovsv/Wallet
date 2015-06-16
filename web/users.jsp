<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Users</title>
    <style>
        a {
            text-decoration: none;
        }
    </style>
</head>
<body>

<h1>USERS</h1>

<table border="1">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Date of birth</td>
        <td>Date of registration</td>
        <td>SEX</td>
        <td>EMAIL</td>
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
