<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New User</title>
</head>
<body>

<form action="/registration" method="post">
  <p><input type="text" name="name"> Name</p>
  <p><input type="text" name="date of birth"> Date of birth</p>
  <p><input type="text" name="sex"> Sex</p>
  <p><input type="text" name="email"> Email</p>
  <p><input type="text" name="password"> Password</p>
  <button type="submit">Create</button>
</form>

</body>
</html>
