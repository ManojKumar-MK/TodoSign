<%@ page import="com.example.todosign.util.ErrorCodeUtil" %><%--
  Created by IntelliJ IDEA.
  User: WELCOME
  Date: 1/6/2022
  Time: 1:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>

<h1>The Page has some technical Issue.</h1>

<%

    ErrorCodeUtil errorCodeUtil = (ErrorCodeUtil) request.getAttribute("error");
%>


<h1> Error Code : <%= errorCodeUtil.getErrorCode()%></h1>

</br>

<h1> Message : <%= errorCodeUtil.getMessage()%></h1>

<a href="<%= request.getContextPath() %>">GO TO HOME PAGE</a>




</body>
</html>
