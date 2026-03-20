<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 3/20/2026
  Time: 8:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Register Page
<div class="main">
    <%
    String errorMessage =(String) request.getAttribute("error");
    if(errorMessage == null){
        errorMessage="";
    }
    %>
    <%= errorMessage %>
    <form method="post" action="register">
        <div class="input-field">
            <label>Full Name</label>
            <input type="text" name="fullname">
        </div>
        <div class="input-field">
            <label>Email </label>
            <input type="text" name="email">
        </div>
        <div class="input-field">
            <label>Password</label>
            <input type="text" name="password">
        </div>
        <div class="input-field">
           <button>Submit</button>
        </div>
    </form>
</div>
</body>
</html>
