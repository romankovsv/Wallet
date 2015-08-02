<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag language="java" %>
<%@ attribute name="wallet" required="true" type="domain.Wallet" %>

<tr style="border:2px solid #ccc">
    <td>${wallet.id}</td>
    <td>${wallet.type.name}</td>
    <td>${wallet.currency.name}</td>
    <td>${wallet.sum}</td>
</tr>
