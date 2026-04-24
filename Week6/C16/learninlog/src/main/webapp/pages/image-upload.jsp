<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 4/24/2026
  Time: 8:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/components/header.jsp"/>
<html>
<head>
    <title>Image Upload Page</title>
</head>
<body>
${error}
${success}
<h2>Upload a new image with name</h2>
    <form method="post" action="image" enctype="multipart/form-data">
        Name: <input type="text" name="name">
        <input type="file" name="image">
        <button>Add Image</button>
    </form>
</body>
</html>

