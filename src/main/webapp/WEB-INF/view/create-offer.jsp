<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <style>
        .error {
            color: #ff0000;
        }
    </style>
</head>
<body>
    <h2>Создать кредитное предложение</h2>
    <br>
    <h3>Информация по кредиту</h3>
    <br>
    Сумма кредита: ${calcRep.creditAmount} р.
    <br>
    Годовой процент: ${calcRep.intersetRate} %
    <br>
    Срок погашения: ${calcRep.paymentTerm} год(а) / лет
    <br>
    Ежемесячная выплата: ${calcRep.monthlyRepayment}
    <br>
    <br>
    <h3>График платежей</h3>
    <br>
    <table>
        <tr>
            <th>Дата платежа</th>
            <th>Сумма платежа</th>
            <th>Сумма гашения тела кредита</th>
            <th>Сумма гашения процентов</th>
            <c:forEach var="shedule" items="${payShedule}">
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
    <br>
    <h3>Введите информацию о клиенте:</h3>
    <br>
    <div><c:if test="${not empty hasErrors}">
        <c:forEach var="error" items="${hasErrors}">
            <p  class="error">${error.defaultMessage}</p>
        </c:forEach>
    </c:if></div>
    <br>
    <form:form action="/creditRegistration/saveOffer" modelAttribute="client">
        <form:hidden path="id"/>

        Фамилия <form:input path="surname" />
        <br>
        Имя <form:input path="name"/>
        <br>
        Отчество <form:input path="middleName"/>
        <br>
        Телефон <form:input path="phone"/>
        <br>
        Эл. почта <form:input path="email"/>
        <br>
        Номер паспорта <form:input path="passportNumber"/>
        <br>
        <br>
        <input type="submit" value="Оформить кредит">
    </form:form>
    <br>
    <br>
    <br>
    <br>
    <br>
</body>
</html>
