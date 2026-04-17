<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 4/6/2026
  Time: 11:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/components/header.jsp"/>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <p style="color: red;">
        ${error}
    </p>

    Topic List
<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>UserId</th>
        <th>CreatedDate</th>
        <th>Action</th>
    </tr>
    <tbody>
    <c:forEach var="t" items="${topics}">
        <tr>

            <td>${t.getId()}</td>
            <td>${t.getName()}</td>
            <td>${t.getUserId()}</td>
            <td>${t.getCreatedAt()}</td>
            <td>
                <a href="edit-topic?id=${t.getId()}">Edit</a> |
                <a href="topic?action=delete&id=${t.getId()}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
<jsp:include page="/components/footer.jsp"/>