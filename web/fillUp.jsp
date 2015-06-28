<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fill up</title>
    <style>
      <%@include file="style.css"%>
    </style>
</head>
<body>

<h1>Fill up your wallet</h1>

<div class="Block">
    <form action="/user/wallet/fill-up?id=${param.id}" method="post">
        <input type="text" name="sum" required placeholder="Enter the sum">
        <p>
            <input type="submit" name="fill up" value="Fill up!">
        </p>
    </form>
</div>

</body>
</html>
