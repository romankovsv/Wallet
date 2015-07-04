<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Page</title>
    <style>
        <%@include file="css/style.css"%>
    </style>
</head>
<body>

<div class="UserPage">
    <h3>Welcome, ${user.name}</h3>
    <p>
        <button>
            <a href="user/new-wallet">Add Wallet</a>
        </button>
        <button>
            <a href="user/wallet/exchange">Exchange</a>
        </button>
        <button>
            <a href="user/history">History</a>
        </button>
    </p>
    <table>
        <tr>
            <th>№</th>
            <th>Name</th>
            <th>Currency</th>
            <th>Sum</th>
        </tr>
        <c:forEach items="${list}" var="wallet">
            <tr style="border:2px solid #ccc">
                <td>${wallet.id}</td>
                <td>${wallet.systemType.name}</td>
                <td>${wallet.currency.name}</td>
                <td>${wallet.sum}</td>
                <td>
                    <button>
                        <a href="user/wallet/change-balance?id=${wallet.id}&sum=${wallet.sum}">Add/Get</a>
                    </button>
                </td>
                <td>
                    <button>
                        <a href="user/delete-wallet?id=${wallet.id}">Delete</a>
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
    <p>
        <button>
            <a href="logout">Logout</a>
        </button>
        <button>
            <a href="user/delete-account">Delete Account</a>
        </button>
        <button>
            <a href="user/change-data">Change data</a>
        </button>
    </p>
</div>

</body>
</html>
