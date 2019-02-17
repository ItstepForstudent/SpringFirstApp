<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value="/res/css/1.css"/>">
</head>
<body>
    <h1>${vasia}</h1>

    <c:forEach items="${users}" var="user">
        <div>
                ${user.id} - ${user.name} ${user.pass}
        </div>
    </c:forEach>

    <form action="<c:url value="/adduser"/>" method="post">
        <input type="text" name="name">
        <input type="text" name="pass">
        <input type="submit">
    </form>
</body>
</html>
