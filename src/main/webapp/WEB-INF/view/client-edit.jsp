<%--
  Created by IntelliJ IDEA.
  User: Victoria
  Date: 24.10.2021
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>
        .error {
            color: #ff0000;
        }
    </style>
</head>
<body>
<h2>Изменение информации о клиенте</h2>
<br>
<div><c:if test="${not empty hasErrors}">
    <c:forEach var="error" items="${hasErrors}">
        <p  class="error">${error.defaultMessage}</p>
    </c:forEach>
</c:if></div>
<form:form action="saveNewClients" modelAttribute="client">

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
    <input type="submit" value="Сохранить">
</form:form>
<br>
<input type="button" value="На главную"
       onclick="window.location.href = '/credit'">
</body>
</html>