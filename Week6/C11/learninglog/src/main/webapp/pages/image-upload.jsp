<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 4/24/2026
  Time: 11:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<p style="color:red;">${error}</p>
<p style="color:green;">${success}</p>

<form method="post" action="image" enctype="multipart/form-data">
    Name: <input type="text" name="name">
    <input type="file" name="image">
    <button>Submit</button>
</form>
</body>
</html>
