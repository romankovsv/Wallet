<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Currency</title>
</head>
<body>

<fieldset>
    <legend>CURRENCY</legend>
    <table>
        <tr>
            <td>ID</td>
            <td>Name</td>
        </tr>
        <c:forEach items="${requestScope.list}" var="currency">
            <tr>
                <td>${currency.id}</td>
                <td>${currency.name}</td>
                <td>
                    <button>
                        <a href="delete-currency?id=${currency.id}">Delete</a>
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
</fieldset>

</body>
</html>