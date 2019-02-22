
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value="/res/css/1.css"/>">
</head>
<body>
<h1>${vasia}</h1>
<c:if test="${auth}">
    Hello, ${name}
    <form method="post" action="<c:url value="/logout"/>">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button>logout</button>
    </form>
</c:if>

<c:if test="${!auth}">

    <a href="<c:url value="/login"/>">login</a>
    <a href="<c:url value="/register"/>">register</a>
</c:if>
</body>