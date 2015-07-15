<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="text" />

<html>
<head>
  <title>History</title>
  <style>
    <%@include file="../../css/style.css"%>
  </style>
</head>
<body>

<div class="Position History">
  <table>
    <tr>
      <th><fmt:message key="history.from" /></th>
      <th><fmt:message key="history.to" /></th>
      <th><fmt:message key="history.date" /></th>
      <th><fmt:message key="history.time" /></th>
      <th><fmt:message key="history.sum" /></th>
    </tr>
    <c:forEach items="${list}" var="history">
      <tr style="border:2px solid #ccc">
        <c:choose>
          <c:when test="${history.walletIdFrom != 0}">
            <td>${history.walletIdFrom}</td>
          </c:when>
          <c:otherwise>
            <td>Add</td>
          </c:otherwise>
        </c:choose>
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