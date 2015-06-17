<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>System Type</title>
  <style>
    <%@include file="style.css"%>
  </style>
</head>
<body>

<h1>SYSTEM TYPE</h1>

<table border="1">
  <tr>
    <td>ID</td>
    <td>Name</td>
  </tr>
  <c:forEach items="${list}" var="type">
    <tr>
      <td>${type.id}</td>
      <td>${type.name}</td>
      <td>
        <button>
          <a href="delete-type?id=${type.id}">Delete</a>
        </button>
      </td>
    </tr>
  </c:forEach>
</table>

</body>
</html>
