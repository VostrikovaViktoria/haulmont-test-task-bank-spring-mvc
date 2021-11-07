<%--
  Created by IntelliJ IDEA.
  User: Victoria
  Date: 26.10.2021
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
    <h2>Сформировать кредитное предложение</h2>
    <br>
    <form:form action="/creditRegistration/calcRepayment" modelAttribute="calcRepayments">
        <h4>Введите сумму кредита:</h4>
        <form:input path="creditAmount" />
        <br>
        <br>
        <h4>Выберите срок погашения кредита:</h4>
        <br>
        <form:radiobutton path="paymentTerm" value="1"/>1 год
        <form:radiobutton path="paymentTerm" value="3"/>3 года
        <form:radiobutton path="paymentTerm" value="5"/>5 лет
        <br>
        <br>
        <input type="submit" value="Рассчитать">
    </form:form>
    <hr>
    <br>
    <br>
    <h2>Итог:</h2>
    <form:form action="/creditRegistration/createOffer">
        <h3>${calcRepayments.intersetRate} % годовых</h3>
        <br>
        <h3>Сумма ежемесячного платежа с учетом процентной ставки: ${calcRepayments.monthlyRepayment} руб/мес</h3>
        <br>
        <br>
        <input type="submit" value="Сформировать предложение">
    </form:form>
    <br>
    <input type="button" value="На главную"
           onclick="window.location.href = '../credit/'">
</body>
</html>
