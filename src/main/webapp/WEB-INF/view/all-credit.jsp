<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=utf-8" %>
<html>
<body>
<h2>Кредиты</h2>
<br>
<table>
    <tr>
        <th>Лимит по кредиту (р.)</th>
        <th>Процентная ставка (%)</th>
        <c:forEach var="credit" items="${allCredits}">
            <c:url var="updateButton" value="/credit/updateInfo">
                <c:param name="creditId" value="${credit.id}"/>
            </c:url>

            <c:url var="deleteButton" value="/credit/deleteCredit">
                <c:param name="creditId" value="${credit.id}"/>
            </c:url>
            <tr>
                <td>${credit.creditLimit}</td>
                <td>${credit.intersetRate}</td>
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
<input type="button" value="Добавить"
 onclick="window.location.href = 'addNewCredit'">
<br>
<br>
<input type="button" value="На главную"
       onclick="window.location.href = '../credit/'">
</body>
</html>
