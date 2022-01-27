<%--
  Created by IntelliJ IDEA.
  User: WELCOME
  Date: 1/12/2022
  Time: 6:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <link rel="icon" href="images/favicon.png" type="image/x-icon">
    <title>Login Page</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body>



<h1> Login Page </h1>


<%

    if(session.getAttribute("error") != null)
    {
        %>
<p><%= session.getAttribute("error")%></p>

<%
    }
%>


<% session.removeAttribute("error");%>

<div style="text-align: center;">

    <form id = "loginform" action="${pageContext.request.contextPath}/Login" onsubmit="return validateForm()" method="post">

        <input style="margin: 20px" id = "email" type="text" name="email" placeholder="Email"  required/><br>
        <input style="margin: 20px" id = "password" type="password" name="password" placeholder="Password"  required/><br>
        <button style="margin: 20px" id = "loginbtn" type="submit">Login</button>


    </form>

</div>

<script>

    function validateForm()
    {
        var REGEX = /\S+@\S+\.\S+/;
        var email = $("#email").val();
        var password = $("#password").val();

        if(!REGEX.test(email))
        {
            alert("Email pattern not look good");
            return false;
        }

        else
            return true;

    }

</script>

</body>
</html>
