<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login Page</title>
  <style>
    <%@include file="style.css"%>
  </style>
</head>
<body>

<h1>Login, please.</h1>

<div class="Block">
  <form action="login" method="post">
    Email<br>
    <input type="text" name="email" required><br>
    Password<br>
    <input type="password" name="password" required><br>
    <p>
      <input type="submit" name="enter" value="Enter">
      <input type="button" name="registration" value="Registration" onclick="parent.location='/registration.jsp'" />
    </p>
  </form>
</div>

</body>
</html>
