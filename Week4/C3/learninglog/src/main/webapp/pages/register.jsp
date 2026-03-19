<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 3/19/2026
  Time: 11:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Register Page
<%
    String error = (String) request.getAttribute("error");
    if(error == null ){
        error="";
    }
%>

<p class="col-first" style="color: red">
    <%= error %></p>
    <form method="post" action="register">
        <div class="input-fields">
            <label>Full Name</label>
            <input type="text" name="fullname" >
        </div>
        <div class="input-fields">
            <label>Email </label>
            <input type="email" name="email" >
        </div>
        <div class="input-fields">
            <label>Password</label>
            <input type="text" name="password" required>
        </div>
        <button type="submit">Submit</button>
    </form>
</body>
</html>
