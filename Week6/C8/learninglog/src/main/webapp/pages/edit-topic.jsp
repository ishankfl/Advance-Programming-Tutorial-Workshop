<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 4/13/2026
  Time: 3:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/components/header.jsp"/>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Edit Topic</h2>
    <form method="post" action="topic">
        <input type="text" value="edit" name="action">
        <input type="text" value="${topic.getId()}" name="id">
        <input type="text" value="${topic.getName()}" name="topic-name">
        <button>Submit Button</button>

    </form>
</body>
</html>
<jsp:include page="/components/footer.jsp" />