<%@ page import="com.learninglog.learninglogproject.user.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 4/3/2026
  Time: 11:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User userObject =(User) session.getAttribute("user");
    int id = 0;
    if(userObject!=null){
        id=userObject.getId();
    }
%>
    <form method="post" action="topic">

        <input type="hidden" value="add" name="action">
        <br>
        <label>UserId</label>
        <input type="text" value="<%=id%>" name="user-id" disabled>
        <br>
        <label>Topic Name</label>
        <input type="text" name="topic-name">
        <br>
        <button>Add Topic</button>
    </form>
</body>
</html>
