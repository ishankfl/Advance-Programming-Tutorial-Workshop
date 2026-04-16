<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 4/12/2026
  Time: 3:15 PM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="/components/header.jsp" />
    <h1>Edit Topic Page</h1>
    <p style="color: red">${error}</p>
    <p style="color:green;">${success}</p>
    <form>
        <input type="text" name="id" value="${topic.id}" readonly>
        <input type="text" name="topic-name" value="${topic.name} ">
        <button>Update</button>
    </form>

<jsp:include page="/components/footer.jsp" />

