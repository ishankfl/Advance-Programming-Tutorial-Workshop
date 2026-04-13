<%@ page import="com.learninglog.learninglogproject.user.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 3/30/2026
  Time: 8:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    `<%
        User userObj = (User) session.getAttribute("user");
    %>

    <% if(userObj == null ){
        response.sendRedirect("/login");
    }%>

Name: <%=userObj.getName()%><br>
Id: <%=userObj.getId()%>


</body>
</html>
