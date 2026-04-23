<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 4/23/2026
  Time: 2:42 PM
  To change this template use File | Settings | File Templates.
--%>

<jsp:include page="/components/header.jsp"/>
    <form method="post" action="image" enctype="multipart/form-data">
        Name:<input type="text" name="name">
        <br>
        Choose your Image:
        <br>
        <input type="file" name="image">
        <br>
        <button>Add</button>
    </form>

<jsp:include page="/components/footer.jsp"/>