<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Wallet</title>
    <style>
        <%@include file="style.css"%>
    </style>
</head>
<body>

<h1>New Wallet</h1>

<table>
    <tr bordercolor="solid black">
        <th>System type</th>
        <th>Currency type</th>
    </tr>
    <c:forEach items="${type}" var="type">
        <c:forEach items="${sc}" var="sc">
            <c:forEach items="${currency}" var="currency">
                <c:if test="${type.id == sc.systemId}">
                    <c:if test="${currency.id == sc.currencyId}">
                        <tr>
                            <td>${type.name}</td>
                            <td>${currency.name}</td>
                            <td>
                                <button>
                                    <a href="new-wallet/create?type=${type.id}&currency=${currency.id}">Create</a>
                                </button>
                            </td>
                        </tr>
                    </c:if>
                </c:if>
            </c:forEach>
        </c:forEach>
    </c:forEach>
</table>

</body>
</html>
