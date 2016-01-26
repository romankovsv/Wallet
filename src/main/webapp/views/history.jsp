<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>

<html>
<head>
    <title>History</title>
</head>
<body>

<fieldset>
    <legend>History</legend>
    <table>
        <tr>
            <th><fmt:message key="history.from"/></th>
            <th><fmt:message key="history.to"/></th>
            <th><fmt:message key="history.date"/></th>
            <th><fmt:message key="history.time"/></th>
            <th><fmt:message key="history.sum"/></th>
        </tr>
        <c:forEach items="${requestScope.list}" var="history">
            <tr style="border:2px solid #ccc">
                <c:choose>
                    <c:when test="${history.walletIdFrom != 0}">
                        <td>${history.walletIdFrom}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Add</td>
                    </c:otherwise>
                </c:choose>
                <td>${history.walletIdTo}</td>
                <td>${history.date}</td>
                <td>${history.time}</td>
                <td>${history.sum}</td>
            </tr>
        </c:forEach>
    </table>
</fieldset>

</body>
</html>