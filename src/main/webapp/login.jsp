<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" scope="session" />
<fmt:setBundle basename="text" scope="session" />

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Login page</title>
  <link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="Position General">
  <form>
    <select id="language" name="language" onchange="submit()">
      <option value="en" ${language == 'en' ? 'selected' : ''}>En</option>
      <option value="ru" ${language == 'ru' ? 'selected' : ''}>Ru</option>
    </select>
  </form>
  <h3><fmt:message key="login.title" /></h3>
  <form action="login" method="post">
    <input type="email" name="email" required placeholder="Email"><br>
    <input type="password" name="password" required placeholder=<fmt:message key="login.password" />><br>
    <%--${error}--%>
    <p>
      <input type="submit" name="enter" value=<fmt:message key="login.enter" />>
      <input type="button" name="registration" value=<fmt:message key="login.registration" /> onclick="parent.location='views/user/registration.jsp'" />
    </p>
  </form>
</div>

</body>
</html>
