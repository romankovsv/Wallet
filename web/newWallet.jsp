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

<form action="new-wallet/create" method="post">
    <table>
        <tr bordercolor="solid black">
            <th>System type</th>
            <th>Currency type</th>
        </tr>
        <c:forEach items="${type}" var="type">
            <c:forEach items="${sc}" var="sc">
                <c:forEach items="${currency}" var="currency">
                    <c:if test="${type.id == sc.system_id}">
                        <c:if test="${currency.id == sc.currency_id}">
                            <tr>
                                <td>${type.name}</td>
                                <td>${currency.name}</td>
                                <td><input type="submit" name="create" value="Create"></td>
                            </tr>
                        </c:if>
                    </c:if>
                </c:forEach>
            </c:forEach>
        </c:forEach>
    </table>
</form>

</body>
</html>
