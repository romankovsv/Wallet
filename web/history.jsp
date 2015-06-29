<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>History</title>
  <style>
    <%@include file="style.css"%>
  </style>
</head>
<body>

<div class="History">
  <table cellpadding="1">
    <tr>
      <th>From</th>
      <th>To</th>
      <th>Date</th>
      <th>Time</th>
      <th>Sum</th>
    </tr>
    <c:forEach items="${list}" var="history">
      <tr style="border:2px solid #ccc">
        <td>${history.walletIdFrom}</td>
        <td>${history.walletIdTo}</td>
        <td>${history.date}</td>
        <td>${history.time}</td>
        <td>${history.sum}</td>
      </tr>
    </c:forEach>
  </table>
</div>

</body>
</html>
