<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ct" tagdir="/WEB-INF/tags" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="text" />

<html>
<head>
    <title>User Page</title>
    <style>
        <%@include file="../../css/style.css"%>
    </style>
</head>
<body>

<div class="Position UserPage">
    <h3><fmt:message key="user.title" />, ${user.name}</h3>
    <p>
        <button>
            <a href="user/new-wallet"><fmt:message key="user.addWallet" /></a>
        </button>
        <button>
            <a href="user/wallet/exchange"><fmt:message key="user.exchange" /></a>
        </button>
        <button>
            <a href="user/history"><fmt:message key="user.history" /></a>
        </button>
    </p>
    <table>
        <tr>
            <th>№</th>
            <th><fmt:message key="user.walletName" /></th>
            <th><fmt:message key="user.currencyName" /></th>
            <th><fmt:message key="user.sum" /></th>
        </tr>
        <c:forEach items="${list}" var="wallet">
            <ct:walletInfo wallet="${wallet}"/>
            <tr>
                <td>
                    <button>
                        <a href="user/wallet/change-balance?id=${wallet.id}&sum=${wallet.sum}"><fmt:message
                                key="user.balance"/></a>
                    </button>
                </td>
                <td>
                    <button>
                        <a href="user/delete-wallet?id=${wallet.id}"><fmt:message key="user.deleteWallet"/></a>
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
    <p>
        <button>
            <a href="logout"><fmt:message key="user.logout" /></a>
        </button>
        <button>
            <a href="<c:url value="/user/delete-account"/>"><fmt:message key="user.deleteAccount" /></a>
        </button>
        <button>
            <a href="user/edit"><fmt:message key="user.edit" /></a>
        </button>
    </p>
</div>

</body>
</html>