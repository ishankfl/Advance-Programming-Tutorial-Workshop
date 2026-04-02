<%@ page import="com.learninglog.learninglogproject.user.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 4/2/2026
  Time: 3:03 PM
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
    int id = 0;
    if(userObj!=null){
        id = userObj.getId();
    }
%>
<form method="post" action="topic">

    <label>Action : </label>
    <br>
    <input type="text" value="add" name="action">
    <br>
    <input type="text" value="<%=id%>" name="user_id">
    <br>
    <label>Name</label>: <input type="text" name="topic_name">
    <button>Add Topic</button>
</form>
</body>
</html>
