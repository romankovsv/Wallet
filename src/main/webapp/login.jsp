<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login Page</title>
  <style>
    <%@include file="css/style.css"%>
  </style>
</head>
<body>

<div class="GeneralBlock">
  <h3>Login, please</h3>
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
