<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="text" />

<html>
<head>
    <title>Exchange</title>
    <style>
        <%@include file="../../css/style.css"%>
    </style>
</head>

<body>
<div class="Position General">
    <h3>Make exchange</h3>
    <form action="<c:url value="/user/wallet/exchange"/>" method="post">
        <input type="number" name="firstId" required placeholder="Enter № of wallet from"><br>
        <input type="number" name="secondId" required placeholder="Enter № of wallet to"><br>
        <input type="number" name="sum" required placeholder="Sum">
        ${error}
        <p>
            <input type="submit" name="exchange" value="Exchange">
        </p>
    </form>
</div>
</body>
</html>
