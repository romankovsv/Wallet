<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Currency</title>
  <style>
    a {
      text-decoration: none;
    }
  </style>
</head>
<body>

<h1>CURRENCY</h1>

<table border="1">
  <tr>
    <td>ID</td>
    <td>Name</td>
  </tr>
  <c:forEach items="${list}" var="currency">
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

</body>
</html>