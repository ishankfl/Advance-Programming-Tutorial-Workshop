<%@ page import="com.learninglog.learninglogproject.user.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 3/30/2026
  Time: 5:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<p style="color: red">${error}</p>
<p style="color: green">${success}</p>
<body>
    <%
        User userDataObj = (User) session.getAttribute("user");
    %>
    <h1>
        Name: <%= userDataObj.getName() %>
    </h1>
    <h2>
        Name: <%= userDataObj.getId() %>
    </h2>
</body>
</html>
