<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="text" />

<html>
<head>
  <title>Login Page</title>
  <style>
    <%@include file="css/style.css"%>
  </style>
</head>
<body>

<div class="Position General">
  <h3>Login, please</h3>
  <fmt:message key="login.enter" />
  <form>
    <select id="language" name="language" onchange="submit()">
      <option value="en" ${language == 'en' ? 'selected' : ''}>En</option>
      <option value="ru" ${language == 'ru' ? 'selected' : ''}>Ru</option>
    </select>
  </form>
  <form action="login" method="post">
    <input type="email" name="email" required placeholder="Email"><br>
    <input type="password" name="password" required placeholder="Password"><br>
    ${error}
    <p>
      <input type="submit" name="enter" value="Enter">
      <input type="button" name="registration" value="Registration" onclick="parent.location='views/user/registration.jsp'" />
    </p>
  </form>
</div>

</body>
</html>
