<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 4/17/2026
  Time: 8:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>


</head>
<p style="color: red">${error}</p>
<p style="color: green">${success}</p>
<body>
    <jsp:include page="/components/header.jsp"/>

    <h2>Edit Form</h2>
    <form method="post" action="edit-topic">
        Id:<input type="text" value="${topicData.id}" name="id" readonly>
        <br>
        Name: <input type="text" name="name" value="${topicData.name}">
        <button>Edit</button>
    </form>
    <jsp:include page="/components/footer.jsp"/>
</body>
</html>
