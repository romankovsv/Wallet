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

<div class="Block">
    <select name="type">
        <c:forEach items="${type}" var="type">
            <option value="type">${type.name}</option>
        </c:forEach>
    </select>

    <select>
        <c:forEach items="${currency}" var="currency">
            <option value="currency">${currency.name}</option>
        </c:forEach>
    </select>
    <p>
        <input type="submit" value="Create" name="create">
    </p>
</div>

</body>
</html>
