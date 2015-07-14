<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ct" uri="MyCustomTags" %>
<html>
<head>
    <title>New Wallet</title>
    <style>
        <%@include file="../../css/style.css"%>
    </style>
</head>
<body>

<div class="Position NewWallet">
    <h3>New Wallet</h3>
    <table class="Table">
        <tr>
            <td>Name</td>
            <td>Currency</td>
        </tr>
        <ct:listOfWallets types="${type}" sc="${sc}" currency="${currency}" />
    </table>
</div>

</body>
</html>
