<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <style>
        <%@include file="style.css"%>
    </style>
</head>
<body>

<h1>Registration.</h1>

<div class="RegistrationBlock">
    <form action="/registration" method="post">
        <input type="text" name="name" required placeholder="Name"><br>
        <input type="text" name="date of birth" required placeholder="Date of birth"><br>
        <input type="text" name="sex" required placeholder="Sex"><br>
        <input type="text" name="email" required placeholder="Email"><br>
        <input type="text" name="password" required placeholder="Password">
        <p><input type="submit" name="create" value="Create"></p>
    </form>
</div>

</body>
</html>
