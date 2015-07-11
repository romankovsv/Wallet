<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fill up</title>
    <style>
      <%@include file="../../css/style.css"%>
    </style>
</head>
<body>

<div class="GeneralBlock">
    <h3>Enter the sum</h3>
    <form action="/user/wallet/change-balance?id=${param.id}&sum=${param.sum}" method="post">
        <input type="text" name="operation" required placeholder="Enter the sum">
        ${error}
        <p>
            <input type="submit" name="change" value="Change">
        </p>
    </form>
</div>

</body>
</html>
