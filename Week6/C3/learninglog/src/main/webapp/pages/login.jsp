<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>

<!-- Display error message if exists -->
<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>

<form method="post" action="login">
    <label>Email: </label>
    <input type="text" name="email" value="${param.email}" required/>

    <label>Password: </label>
    <input type="password" name="password" required/>

    <button type="submit">Login</button>
</form>

<a href="register">Don't have any account? Register here</a>

</body>
</html>