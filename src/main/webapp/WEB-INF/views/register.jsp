<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${error!=null}" >
    <b>${error}</b>
</c:if>


<form action="<c:url value="/register"/>" method="post">
    <dl>
        <dt>Login:</dt>
        <dd><input type="text" name="name"
        <c:if test="${name!=null}" >
            value="${name}"
        </c:if>
        ></dd>
        <dt>Password:</dt>
        <dd><input type="password" name="pass"></dd>
        <dt>Password confirmation:</dt>
        <dd><input type="password" name="pass2"></dd>
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
        <input type="submit">
    </dl>
</form>
</body>
</html>
