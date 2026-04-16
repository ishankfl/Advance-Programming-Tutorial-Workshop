<jsp:include page="/components/header.jsp"/>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<h2>
    Edit Topic
</h2>
    <form method="post" action="topic">
        <input type="text" value="edit" name="action">

        <label>Id</label>
        <input type="number" value="${topic.id}" name="id" readonly><br>

        <label>Topic Name</label>
        <input type="text" value="${topic.name}" name="name" >
        <button>Edit</button>
    </form>

<jsp:include page="/components/footer.jsp"/>