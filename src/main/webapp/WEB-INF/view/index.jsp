<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
    <title>Главная</title>
</head>
<body>
<table style="align-items: center">
    <tr>
        <td>
            <input type="button" value="Сформировать кредитное предложение"
                   onclick="window.location.href='/creditRegistration/chooseOffer'">
        <br>
        <br>
            <input type="button" value="Просмотреть список клиентов"
                   onclick="window.location.href='/client/showClients'">
        <br>
        <br>
            <input type="button" value="Просмотреть виды кредита"
                   onclick="window.location.href='/credit/showCredits'">
        </td>
    </tr>
</table>
</body>
</html>
