<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=utf-8" %>
<html>
<body>
<h2>Кредитное предложение</h2>
<br>
<h2>Кредит</h2>
<table>
    <tr>
        <th>Лимит по кредиту (р.)</th>
        <th>Процентная ставка (%)</th>
        <th>Сумма кредита</th>
            <tr>
                <td>${offer.credit.creditLimit}</td>
                <td>${offer.credit.intersetRate}</td>
                <td>${offer.creditAmount}</td>
            </tr>
    </tr>
</table>
<br>
<h2>График платежей</h2>
<br>
<table>
    <tr>
        <th>Дата платежа</th>
        <th>Сумма платежа</th>
        <th>Сумма гашения тела кредита</th>
        <th>Сумма гашения процентов</th>
        <c:forEach var="shedule" items="${shedules}">
            <tr>
                <td>${shedule.datePayment}</td>
                <td>${shedule.paymentAmount}</td>
                <td>${shedule.amountBodyCredit}</td>
                <td>${shedule.amountInterset}</td>
            </tr>
         </c:forEach>
    </tr>
</table>
<br>
<input type="button" value="Назад"
 onclick="window.location.href = 'showClients'">
</body>
</html>
