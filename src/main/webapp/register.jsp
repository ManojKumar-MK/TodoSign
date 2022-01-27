<%--
  Created by IntelliJ IDEA.
  User: WELCOME
  Date: 1/12/2022
  Time: 6:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="icon" href="images/favicon.png" type="image/x-icon">
    <title>Register Page</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body>

<h1> RegisterPage </h1>


<div style="text-align: center;">

    <form action="${pageContext.request.contextPath}/Register" method="post" onsubmit="return validateForm()">


        <input style="margin: 20px" type="text" name="firstname"  id="firstname" placeholder="First Name" required/><br>

        <input style="margin: 20px" type="text" name="lastname" id="lastname" placeholder="Last Name" required/><br>


        <input style="margin: 20px" type="text" name="phone" id="phone" placeholder="Phone" required/><br>

        <input style="margin: 20px" type="text" name="email" id="email" placeholder="Email" required/><br>


        <input style="margin: 20px" type="password" name="password"  id="password" placeholder="Password" required/><br>


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