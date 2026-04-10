<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        *{
            margin:0;
            padding:0;
        }
        .main{
            display: flex;
            flex-direction: row;
            gap: 10px;
            padding: 20px;
        }
        a{
            color: black;
            font-weight: bold;
            font-size: medium;
        }
    </style>
</head>
<body>
<div class="main">
    <a href="/topic?page=list">View Topic</a><br>
    <a href="/topic">Add Topic</a><br>
    <a href="/login">Login</a><br>
    <a href="register">Register</a><br>
</div>

</body>
</html>