<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ct" uri="MyCustomTags" %>
<fmt:setLocale value="${sessionScope.language}"/>

<html>
<head>
    <title>New Wallet</title>
</head>
<body>

<fieldset>
    <legend><fmt:message key="wallet.title"/></legend>
    <table class="Table">
        <ct:listOfWallets types="${requestScope.type}" sc="${requestScope.sc}" currency="${requestScope.currency}"/>
    </table>
</fieldset>

</body>
</html>
