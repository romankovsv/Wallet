<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <style>
        <%@include file="../../css/style.css"%>
    </style>
</head>
<body>

<div class="Registration">
    <h3>Registration.</h3>
    <form action="<c:url value="/registration"/>" method="post">
        <input type="text" name="name" required placeholder="Name"><br>
        <input type="text" name="date of birth" required placeholder="Date of birth"><br>
        <input type="text" name="sex" required placeholder="Sex"><br>
        <input type="email" name="email" required placeholder="Email"><br>
        <input type="text" name="password" required placeholder="Password">
        <p><input type="submit" name="create" value="Create"></p>
    </form>
    ${error}
</div>

</body>
</html>