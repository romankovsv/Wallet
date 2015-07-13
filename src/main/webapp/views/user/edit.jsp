<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Change data</title>
  <style>
    <%@include file="../../css/style.css"%>
  </style>
</head>
<body>

<div class="Registration">
  <h3>Make changes.</h3>

  <form action="<c:url value="/user/edit"/>" method="post">
    <input type="text" name="name" required placeholder="Name" value="${user.name}"><br>
    <input type="text" name="date" required placeholder="Date of birth" value="${user.dateOfBirth}"><br>
    <input type="text" name="sex" required placeholder="Sex" value="${user.sex}"><br>
    <input type="email" name="email" required placeholder="Email" value="${user.email}"><br>
    <input type="password" name="password" required placeholder="Password" value="${user.password}"><br>
    <p><input type="submit" name="create" value="Change"></p>
  </form>
  ${error}
</div>

</body>
</html>