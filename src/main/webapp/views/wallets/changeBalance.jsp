<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}" />

<html>
<head>
    <title>Change balance</title>
    <link href="../../css/style.css" rel="stylesheet" type="text/css">
<body>

<div class="Position General">
    <h3><fmt:message key="balance.title" /></h3>
    <form action="<c:url value="/user/wallet/change-balance?id=${param.id}&sum=${param.sum}"/>" method="post">
        <label>
            <input type="number" name="operation" required>
        </label>
        <%--${error}--%>
        <p>
            <input type="submit" name="change" value=<fmt:message key="balance.change" />>
        </p>
    </form>
</div>

</body>
</html>