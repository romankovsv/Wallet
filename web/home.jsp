<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Main Page</title>
  <style>
    a {
      text-decoration: none;
    }
  </style>
</head>

<h1>Main Page</h1>

<body>
<form action="/login" method="post">
  <p><input type="text" name="email"> : Email</p>
  <p><input type="text" name="password"> : Password</p>
  <input type="submit" name="enter" value="Enter">
</form>
<button>
  <a href="/newuser.jsp">Registration</a>
</button>
</body>
</html>
