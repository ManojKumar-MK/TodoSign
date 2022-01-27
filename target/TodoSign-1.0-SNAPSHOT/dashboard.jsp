
<%@ page import="com.example.todosign.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.todosign.model.Admin" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.example.todosign.db.TodoDao" %><%--
  Created by IntelliJ IDEA.
  User: WELCOME
  Date: 1/5/2022
  Time: 4:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
<%

    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setDateHeader("Expires", 0);

    TodoDao todoDao = new TodoDao(config.getServletContext());
    List<User> userList = null;
    try {
        userList = todoDao.getUsers();
    } catch (SQLException e) {
        e.printStackTrace();
    }

%>


<h1>List Users</h1>

<table border="1" width="2px">


    <tr><th>ID</th> <th>FirstName</th> <th>LastName</th> <th>Phone</th> <th>Email</th> <th>Password</th><th>Edit</th><th>Delete</th> </tr>
    <% for(User user : userList)
    {%>

    <tr>
        <td><%= user.getId() %></td>
        <td><%= user.getFirstName() %></td>
        <td><%= user.getLastName() %></td>
        <td><%= user.getPhone() %></td>
        <td><%= user.getEmail() %></td>
        <td><%= user.getPassword() %></td>
        <td> <a href="edit?id=<%= user.getId()%>">Edit  </a> </td>

        <td> <a href="delete?id=<%= user.getId()%>">Delete  </a> </td>
    </tr>

    <% }%>
</table>


<form action="${pageContext.request.contextPath}/admin/logout" method="post">

    <button style="margin: 20px" type="submit" value="Logout"> Logout </button>

</form>


</body>
</html>
