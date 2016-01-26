<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Users</title>
</head>
<body>

<fieldset>
    <legend>USERS</legend>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Date of birth</th>
            <th>Date of registration</th>
            <th>SEX</th>
            <th>EMAIL</th>
        </tr>
        <c:forEach items="${requestScope.list}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.dateOfBirth}</td>
                <td>${user.dateOfRegistration}</td>
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
</fieldset>

</body>
</html>