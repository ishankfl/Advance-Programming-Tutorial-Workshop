<jsp:include page="/components/header.jsp"/>

<h2>Edit Topic </h2>
<form method="post" action="edit-topic" >
    Id:<input type="text" name="id" value="${topic.id}" readonly><br>
    Name:<input type="text" name="name" value="${topic.name}">
    <button>Edit</button>
</form>
<jsp:include page="/components/footer.jsp"/>
