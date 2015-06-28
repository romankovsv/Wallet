<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exchange</title>
    <style>
        <%@include file="style.css"%>
    </style>
</head>

<h1>Make exchange</h1>

<div class="Block">
    <form action="/user/wallet/exchange" method="post">
        <input type="text" name="firstId" required placeholder="Enter № of wallet from"><br>
        <input type="text" name="secondId" required placeholder="Enter № of wallet to"><br>
        <input type="text" name="sum" required placeholder="Sum">
        <p>
            <input type="submit" name="exchange" value="Exchange">
        </p>
    </form>
</div>

</body>
</html>
