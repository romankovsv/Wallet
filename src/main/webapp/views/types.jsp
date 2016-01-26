<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>System Type</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

<fieldset>
    <legend>SYSTEM TYPE</legend>
    <table>
        <tr>
            <td>ID</td>
            <td>Name</td>
        </tr>
        <c:forEach items="${requestScope.list}" var="type">
            <tr>
                <td>${type.id}</td>
                <td>${type.name}</td>
                <td>
                    <button>
                        <a href="delete-system-type?id=${type.id}">Delete</a>
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
</fieldset>

</body>
</html>
