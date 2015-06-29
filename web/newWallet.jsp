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

<div class="NewWallet">
    <h3>New Wallet</h3>
    <table cellpadding="10">
        <tr>
            <td>Name</td>
            <td>Currency</td>
        </tr>
        <c:forEach items="${type}" var="type">
            <c:forEach items="${sc}" var="sc">
                <c:forEach items="${currency}" var="currency">
                    <c:if test="${type.id == sc.systemId}">
                        <c:if test="${currency.id == sc.currencyId}">
                            <tr style="border: 2px solid #ccc">
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
</div>

</body>
</html>
