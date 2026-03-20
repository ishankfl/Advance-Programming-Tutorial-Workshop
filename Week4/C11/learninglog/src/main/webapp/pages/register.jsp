<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 3/20/2026
  Time: 11:12 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>

    <style>
        /* Styling for the form container */
        form{
            display: flex;
            flex-direction: column;
            width: 400px;
        }

        /* Styling for each input group */
        .input-field{
            display: flex;
            flex-direction: column;
            gap: 10px;
        }
    </style>
</head>

<body>

<%
    // Retrieve error message from request (set by servlet)
    String errorMessage =(String) request.getAttribute("error");
%>

<%=
// Display error message (if any)
        errorMessage
%>

<!-- Registration Form -->
<form method="post" action="register">

    <!-- Full Name Field -->
    <div class="input-field">
        <label>Full Name</label>
        <input type="text" name="fullname">
    </div>

    <!-- Email Field -->
    <div class="input-field">
        <label>Email</label>
        <input type="text" name="email">
    </div>

    <!-- Password Field -->
    <div class="input-field">
        <label>Password</label>
        <input type="text" name="password">
    </div>

    <br>

    <!-- Submit Button -->
    <button>Register</button>

</form>

</body>
</html>