<%@ page import="com.learninglog.learninglogproject.user.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 3/29/2026
  Time: 3:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%
    User userObj = (User) session.getAttribute("user");

  %>
  <h1> USer Name : <%=
    userObj.getName()
  %></h1>
</body>
</html>
