<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 3/20/2026
  Time: 11:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        form{
            display: flex;
            flex-direction: column;
            width: 400px;

        }
        .input-field{
            display: flex;
            flex-direction: column;
            gap: 10px;
        }
    </style>
</head>
<body>
<%
    String errorMessage =(String) request.getAttribute("error");
%>
<%=
errorMessage
%>
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
        <br>
        <button>Register</button>
    </form>
</body>
</html>
