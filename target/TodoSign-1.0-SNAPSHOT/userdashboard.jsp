<%@ page import="com.example.todosign.model.User" %><%--
  Created by IntelliJ IDEA.
  User: WELCOME
  Date: 1/12/2022
  Time: 6:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Dashboard</title>
</head>
<body>



<%

    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setDateHeader("Expires", 0);

    %>



<%

    if(session.getAttribute("success") != null)
    {
%>
<p><%= session.getAttribute("success")%></p></br>

<%
    }
%>


<% session.removeAttribute("success");%>




<%

    session = request.getSession();
    User user = (User) session.getAttribute("user");

%>


<%= user.getEmail()%>

<%= user.getPhone()%>




<form action="${pageContext.request.contextPath}/admin/logout"  method="post">
    <button style="margin: 20px"type="submit">Logout</button>


</form>


</body>
</html>
