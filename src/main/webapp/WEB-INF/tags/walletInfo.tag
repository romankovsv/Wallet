<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag language="java" %>
<%@ attribute name="wallet" required="true" type="database.wallets.Wallet" %>

<tr style="border:2px solid #ccc">
    <td>${wallet.id}</td>
    <td>${wallet.systemType.name}</td>
    <td>${wallet.currency.name}</td>
    <td>${wallet.sum}</td>
    <td>
        <button>
            <a href="user/wallet/change-balance?id=${wallet.id}&sum=${wallet.sum}">Add/Get</a>
        </button>
    </td>
    <td>
        <button>
            <a href="user/delete-wallet?id=${wallet.id}">Delete</a>
        </button>
    </td>
</tr>
