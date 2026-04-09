<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
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
    <c:forEach var="obj" items="${topics}">
        <tr>

            <td>${obj.getId()}</td>
            <td>${obj.getName()}</td>
            <td>${obj.getUserId()}</td>
            <td>${obj.getCreatedAt()}</td>
            <td>
                <a href="topic?page=edit&id=${obj.getId()}">Edit</a> |
                <a href="topic?page=delete&id=${obj.getId()}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>