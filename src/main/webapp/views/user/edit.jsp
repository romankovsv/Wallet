<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}" />

<html>
<head>
  <title>Edit</title>
  <link href="../../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="Position Registration">
  <h3><fmt:message key="edit.title" /></h3>
  <form action="<c:url value="/user/edit"/>" method="post">
    <input type="text" name="name" required placeholder=<fmt:message key="registration.name" /> value="${sessionScope.user.name}"><br>
    <input type="text" name="date" required placeholder=<fmt:message key="registration.date" /> value="${sessionScope.user.dateOfBirth}"><br>
    <input type="text" name="sex" required placeholder=<fmt:message key="registration.sex" /> value="${sessionScope.user.sex}"><br>
    <input type="email" name="email" required placeholder="Email" value="${sessionScope.user.email}"><br>
    <input type="password" name="password" required placeholder=<fmt:message key="registration.password" /> value="${sessionScope.user.password}"><br>
    <p><input type="submit" name="create" value=<fmt:message key="edit.save" />></p>
  </form>
  <%--${error}--%>
</div>

</body>
</html>