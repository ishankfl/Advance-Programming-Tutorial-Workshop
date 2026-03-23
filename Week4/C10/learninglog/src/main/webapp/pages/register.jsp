<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 3/19/2026
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>

<body>

<!-- Main container for the form -->
<div class="container">

    <%
        // Retrieve error message sent from servlet (if validation fails)
        String errorMessage = (String) request.getAttribute("error");
        String successMessage = (String) request.getAttribute("success");
        if(errorMessage==null){
            errorMessage="";
        }
        if(successMessage==null){
            successMessage="";
        }
    %>

    <%=
    // Display error message on the page
            errorMessage
    %>
    <%=
    // Display error message on the page
            successMessage
    %>


    <!-- Registration Form -->
    <form method="post" action="register">

        <!-- Full Name Input -->
        <div class="input-field">
            <label>Full Name</label>
            <input type="text" name="fullname">
        </div>

        <!-- Email Input -->
        <div class="input-field">
            <label>Email</label>
            <input type="text" name="email">
        </div>

        <!-- Password Input -->
        <div class="input-field">
            <label>Password</label>
            <input type="text" name="password">
        </div>

        <!-- Submit Button -->
        <button>SUbmit</button>

        <%-- Alternative submit button (currently commented out) --%>
        <%-- <input type="button" value="submit"> --%>

    </form>

</div>

</body>
</html>