<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User list</title>
</head>
<body>
    <table border="1">
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td><td>${user.userName}</td><td>${user.email}</td>
            </tr>
        </c:forEach>
    </table>

    <form>
        <input type="text" value="${user.userName}"/>
        <input type="text" value="${user.email}"/>
    </form>
</body>
</html>
