<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ct" uri="MyCustomTags" %>
<fmt:setLocale value="${sessionScope.language}" />

<html>
<head>
    <title>New Wallet</title>
    <link href="../../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="Position NewWallet">
    <h3><fmt:message key="wallet.title" /></h3>
    <table class="Table">
        <ct:listOfWallets types="${requestScope.type}" sc="${requestScope.sc}" currency="${requestScope.currency}" />
    </table>
</div>

</body>
</html>
