<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 3/19/2026
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <%
    String errorMessage = (String) request.getAttribute("error");
    %>
    <%= errorMessage %>
    <form method="post" action="register">
        <div class="input-field">
            <label>Full Name</label>
            <input type="text" name="fullname">
        </div>
        <div class="input-field">
            <label>Email</label>
            <input type="text" name="email">
        </div>
        <div class="input-field">
            <label>Password</label>
            <input type="text" name="password">
        </div>
        <button>SUbmit</button>
<%--        <input type="button" value="submit">--%>
    </form>

</div>
</body>
</html>
