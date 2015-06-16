<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Page</title>
    <style>
        a {
            text-decoration: none;
        }
    </style>
</head>
<body>

<h1>Welcome</h1>

<p>
    <button>
        <a href="/user/addwallet">Add Wallet</a>
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

</body>
</html>
