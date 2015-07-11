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

  <form action="/user/change-data" method="post">
    <input type="text" name="name" required placeholder="Name" value="${name}"><br>
    <input type="text" name="date" required placeholder="Date of birth" value="${date}"><br>
    <input type="text" name="sex" required placeholder="Sex" value="${sex}"><br>
    <input type="email" name="email" required placeholder="Email" value="${email}"><br>
    <input type="password" name="password" required placeholder="Password" value="${password}"><br>
    <p><input type="submit" name="create" value="Change"></p>
  </form>
  ${error}
</div>

</body>
</html>
