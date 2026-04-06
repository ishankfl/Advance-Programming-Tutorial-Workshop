<%@ page import="java.util.List" %>
<%@ page import="com.learninglog.learninglogproject.topic.model.Topic" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 4/6/2026
  Time: 8:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Topics</title>
</head>
<body>
TopicList
<%
  List<Topic> topicList = (List<Topic>) request.getAttribute("topics");
%>
<table border="1">
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>UserId</th>
    <th>CreatedDate</th>
  </tr>
  <tbody>
  <% for (Topic topic : topicList)
  {
    %>
    <tr>
      <td><%=topic.getId()%></td>
      <td><%=topic.getName()%></td>
      <td><%=topic.getUser_id()%></td>
      <td><%=topic.getCreatedAt()%></td>
    </tr>
  <%}
  %>
  </tbody>
</table>
</body>
</html>
