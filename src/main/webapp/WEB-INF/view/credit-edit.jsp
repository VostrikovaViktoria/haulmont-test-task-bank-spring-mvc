<%--
  Created by IntelliJ IDEA.
  User: Victoria
  Date: 24.10.2021
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <style>
        .error {
            color: #ff0000;
        }
    </style>
</head>
<body>
<h2>Кредит (добавление/ изменение)</h2>
<br>
<form:form action="/credit/saveNewCredit" modelAttribute="credit">
    <form:hidden path="id"/>
    <table>
        <tr><c:if test="${not empty hasErrors}">
            <c:forEach var="error" items="${hasErrors}">
                <p  class="error">${error.defaultMessage}</p>
            </c:forEach>
        </c:if></tr>
        <tr>
            <td>Лимит по кредиту (р.)  :</td>
            <td> <form:input path="creditLimit" /></td>
        </tr>
        <tr>
            <td>Процентная ставка (%)  :</td>
            <td><form:input path="intersetRate" /></td>
        </tr>
    </table>
    <br>
    <input type="submit" value="Сохранить">
</form:form>
<br>
<input type="button" value="На главную"
       onclick="window.location.href = '/credit'">
</body>
</html>