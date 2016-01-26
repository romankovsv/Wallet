<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>

<html>
<head>
    <title>Exchange</title>
</head>

<body>
<fieldset>
    <legend><fmt:message key="exchange.title"/></legend>
    <form action="<c:url value="/user/wallet/exchange"/>" method="post">
        <input type="number" name="firstId" required placeholder=<fmt:message key="exchange.from"/>><br>
        <input type="number" name="secondId" required placeholder=<fmt:message key="exchange.to"/>><br>
        <input type="number" name="sum" required placeholder=<fmt:message key="exchange.sum"/>>
        <%--${error}--%>
        <p>
            <input type="submit" name="exchange" value=<fmt:message key="exchange"/>>
        </p>
    </form>
</fieldset>
</body>
</html>
