<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}" />

<html>
<head>
    <title>Registration</title>
    <link href="../../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="Position Registration">
    <h3><fmt:message key="registration.title" /></h3>
    <form action="<c:url value="/registration"/>" method="post">
        <input type="text" name="name" required placeholder=<fmt:message key="registration.name" />><br>
        <input type="text" name="date of birth" required placeholder=<fmt:message key="registration.date" />><br>
        <input type="text" name="sex" required placeholder=<fmt:message key="registration.sex" />><br>
        <input type="email" name="email" required placeholder="Email"><br>
        <input type="text" name="password" required placeholder=<fmt:message key="registration.password" />>
        <p><input type="submit" name="create" value=<fmt:message key="registration.create" />></p>
    </form>
    ${error}
</div>

</body>
</html>