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

<h1>Welcome, ${user.name}</h1>

<p>
    <button>
        <a href="user/new-wallet">Add Wallet</a>
    </button>
    <button>
        <a href="user/wallet/exchange">Exchange</a>
    </button>
</p>

<table border="1">
    <tr>
        <th>№</th>
        <th>Name</th>
        <th>Currency</th>
        <th>Sum</th>
    </tr>
    <c:forEach items="${list}" var="wallet">
        <tr>
            <td>${wallet.id}</td>
            <td>${wallet.systemType.name}</td>
            <td>${wallet.currency.name}</td>
            <td>${wallet.sum}</td>
            <td>
                <button>
                    <a href="user/delete-wallet?id=${wallet.id}">Delete</a>
                </button>
            </td>
        </tr>
    </c:forEach>
</table>

<p>
<form action="logout" method="post">
    <input type="submit" value="Logout">
</form>
</p>

</body>
</html>
