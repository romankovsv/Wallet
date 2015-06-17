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
        Name<br>
        <input type="text" name="name"><br>
        Date of birth<br>
        <input type="text" name="date of birth"><br>
        Sex<br>
        <input type="text" name="sex"><br>
        Email<br>
        <input type="text" name="email"><br>
        Password<br>
        <input type="text" name="password">
        <p><input type="submit" name="create" value="Create"></p>
    </form>
</div>

</body>
</html>
