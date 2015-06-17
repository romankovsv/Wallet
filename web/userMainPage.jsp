<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Page</title>
    <style>
        <%@include file="style.css"%>
    </style>
</head>
<body>

<h1>Welcome ${name}</h1>

<p>
    <button>
        <a href="/user/add-wallet">Add Wallet</a>
    </button>
</p>

<table border="1">
    <tr>
        <td>Id</td>
        <td>Sum</td>
    </tr>
    <c:forEach items="${list}" var="wallet">
        <tr>
            <td>${wallet.id}</td>
            <td>${wallet.sum}</td>
        </tr>
    </c:forEach>
</table>

<p>
<form action="/logout" method="post">
    <input type="submit" value="Logout">
</form>
</p>

</body>
</html>
