<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=utf-8" %>
<html>
<body>
<h2>Клиентская база</h2>
<br>
<table>
    <tr>
        <th>Фамилия</th>
        <th>Имя</th>
        <th>Отчество</th>
        <th>Телефон</th>
        <th>Email</th>
        <th>Номер паспорта</th>
        <th>Операции</th>
        <c:forEach var="client" items="${allClients}">
            <c:url var="updateButton" value="/client/updateInfo">
                <c:param name="clientId" value="${client.id}"/>
            </c:url>

            <c:url var="deleteButton" value="/client/deleteClient">
                <c:param name="clientId" value="${client.id}"/>
            </c:url>
            <c:url var="showCreditButton" value="/client/showCreditClient">
                <c:param name="clientId" value="${client.id}"/>
            </c:url>
            <tr>
                <td>${client.surname}</td>
                <td>${client.name}</td>
                <td>${client.middleName}</td>
                <td>${client.phone}</td>
                <td>${client.email}</td>
                <td>${client.passportNumber}</td>
                <td>
                    <input type="button" value="Просмотреть кредитное предложение"
                    onclick="window.location.href='${showCreditButton}'">
                </td>
                <td>
                    <input type="button" value="Изменить"
                           onclick="window.location.href='${updateButton}'">
                </td>
                <td>
                    <input type="button" value="Удалить"
                           onclick="window.location.href='${deleteButton}'">
                </td>

            </tr>
        </c:forEach>
    </tr>
</table>
<br>
<input type="button" value="На главную"
 onclick="window.location.href = '../credit/'">
</body>
</html>
