<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fill up</title>
    <style>
      <%@include file="style.css"%>
    </style>
</head>
<body>

<div class="GeneralBlock">
    <h3>Enter the sum</h3>
    <form action="/user/wallet/change-balance?id=${param.id}" method="post">
        <input type="text" name="sum" required placeholder="Enter the sum">
        <p>
            <input type="submit" name="fill up" value="Fill up!">
        </p>
    </form>
</div>

</body>
</html>
