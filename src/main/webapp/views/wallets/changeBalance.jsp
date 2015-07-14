<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="text" />

<html>
<head>
    <title>Change balance</title>
    <style>
        <%@include file="../../css/style.css"%>
    </style>
</head>
<body>

<div class="Position General">
    <h3>Enter the sum</h3>
    <form action="<c:url value="/user/wallet/change-balance?id=${param.id}&sum=${param.sum}"/>" method="post">
        <input type="text" name="operation" required placeholder="Enter the sum">
        ${error}
        <p>
            <input type="submit" name="change" value="Change">
        </p>
    </form>
</div>

</body>
</html>