<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${sessionScope.language}" />

<html>
<head>
  <title>System Type</title>
  <link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

<h3>SYSTEM TYPE</h3>

<table border="1">
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

</body>
</html>
