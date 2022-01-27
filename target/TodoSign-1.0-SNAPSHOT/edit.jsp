<%@ page import="com.example.todosign.model.User" %>
<%@ page import="com.example.todosign.db.TodoDao" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: WELCOME
  Date: 1/12/2022
  Time: 3:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="icon" href="images/favicon.png" type="image/x-icon">
    <title>Edit Page</title>

</head>
<body>

<h1> Edit Page </h1>


<%

    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setDateHeader("Expires", 0);

%>

<%

    String id = request.getParameter("id"); // ID GOT TO GET RECORD AND THEN MODIFY IT
    TodoDao todoDao = new TodoDao(config.getServletContext());

    User user = null;
    try {
        user = todoDao.getUser(id);
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>

<div style="text-align: center;">

    <form action="${pageContext.request.contextPath}/admin/Edit" method="post" onsubmit="return validateForm()">


        <input type="hidden" name = "id" value="<%= user.getId()%>">
        <input style="margin: 20px" type="text" name="firstname"  id="firstname"  value="<%=user.getFirstName() %>" placeholder="First Name" required /><br>

        <input style="margin: 20px" type="text" name="lastname" id="lastname"  value="<%=user.getLastName() %>" placeholder="Last Name" required/><br>


        <input style="margin: 20px" type="text" name="phone" id="phone"   value="<%=user.getPhone() %>" placeholder="Phone" required/><br>

        <input style="margin: 20px" type="text" name="email" id="email"  value="<%=user.getEmail() %>" placeholder="Email" required/><br>


        <input style="margin: 20px" type="password" name="password"  id="password"  value="<%=user.getPassword() %>" placeholder="Password" required/><br>


        <input style="margin: 20px" type="password" name="confirmpassword"  id="confirm" placeholder="Confirm Password" required/><br>

        <button style="margin: 20px"
                type="submit">Register</button>


    </form>

</div>

<script>

    function validateForm()
    {
        const REGEX = /\S+@\S+\.\S+/;

        var firstname = $("#firstname").val();
        var lastname = $("#lastname").val();
        var phone = $("#phone").val();
        var email = $("#email").val();
        var password = $("#password").val();
        var confirmPassword = $("#confirm").val();

        if(!REGEX.test(email))
        {
            alert("Email pattern not look good");
            return false;
        }
        if(password.length < 8)
        {
            alert("Password Length should be greater than 8");
            return false;
        }

        if(phone.length < 10 || phone.length > 10)
        {
            alert("Phone number length should be 10");
            return false;

        }
        if(password !== confirmPassword)
        {
            alert("Confirm Password should not match with password");
            return false;

        }
        else
            return true

    }
</script>

</body>
</html>
