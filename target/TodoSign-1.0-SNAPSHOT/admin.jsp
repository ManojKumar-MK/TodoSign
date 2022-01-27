<%--
  Created by IntelliJ IDEA.
  User: WELCOME
  Date: 1/12/2022
  Time: 11:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="icon" href="images/favicon.png" type="image/x-icon">
    <title>Admin Page</title>
</head>
<body>

<%

    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setDateHeader("Expires", 0);
%>
<h1> Admin Page </h1>


<div style="text-align: center;">


    <form action="${pageContext.request.contextPath}/admin/Login"  method="post">

        <input style="margin: 20px"  type="text" name="username" placeholder="Username"  required/><br>
        <input style="margin: 20px"  type="password" name="password" placeholder="Password"  required/><br>
        <button style="margin: 20px" type="submit">Login</button>


    </form>

</div>



</body>
</html>
