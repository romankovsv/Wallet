<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>

<html>
<head>
    <title>Registration</title>
</head>
<body>

<fieldset>
    <legend><fmt:message key="registration.title"/></legend>
    <form action="<c:url value="/registration"/>" method="post">
        <input type="text" name="name" required placeholder=<fmt:message key="registration.name"/>><br>
        <input type="text" name="date of birth" required placeholder=
        <fmt:message key="registration.date"/>
                pattern="[1-9][1-9]-[1-9][1-9]-[1-9][0-9][0-9][0-9]"
               title="01-01-1990"><br>
        <input type="text" name="sex" required placeholder=<fmt:message key="registration.sex"/>><br>
        <input type="email" name="email" required placeholder="Email"><br>
        <input type="text" name="password" required placeholder=<fmt:message key="registration.password"/>>

        <p><input type="submit" name="create" value=<fmt:message key="registration.create"/>></p>
    </form>
    <%--${error}--%>
</fieldset>

</body>
</html>