<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 3/20/2026
  Time: 8:59 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Register Page</title>
</head>
<body>

<!-- Page heading -->
Register Page

<div class="main">

    <%
        // Retrieve the error message from the request (set by servlet)
        String errorMessage = (String) request.getAttribute("error");

        // If no error message, initialize as empty string to avoid "null" display
        if (errorMessage == null) {
            errorMessage = "";
        }
    %>

    <!-- Display the error message -->
    <%= errorMessage %>

    <!-- Registration Form -->
    <form method="post" action="register">

        <!-- Full Name input field -->
        <div class="input-field">
            <label>Full Name</label>
            <input type="text" name="fullname">
        </div>

        <!-- Email input field -->
        <div class="input-field">
            <label>Email</label>
            <input type="text" name="email">
        </div>

        <!-- Password input field -->
        <div class="input-field">
            <label>Password</label>
            <input type="text" name="password">
        </div>

        <!-- Submit button -->
        <div class="input-field">
            <button>Submit</button>
        </div>

    </form>

</div>
</body>
</html>