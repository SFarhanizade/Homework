<%--
  Created by IntelliJ IDEA.
  User: farhanizade
  Date: 12/19/21
  Time: 12:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HttpSession userSession = request.getSession();
    Object loggedInUser = userSession.getAttribute("admin");
    if (loggedInUser != null) {
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="../css/bootstrap.css">
</head>
<body class="align-items-center align-content-center mt-1">
<div class="container d-flex w-75 align-items-center">
    <%--    <a href="dashboard.jsp" class="btn btn-primary flex-grow-1 m-auto">name</a>--%>
    <a href="cities.jsp" class="btn btn-primary flex-grow-1 m-auto">cities</a>
    <a href="travels.jsp" class="btn btn-primary flex-grow-1 m-auto">travels</a>
    <a href="tickets.jsp" class="btn btn-primary flex-grow-1 m-auto">tickets</a>
    <a href="../adminLogout" class="btn btn-primary flex-grow-1 m-auto">logout</a>
</div>
</body>
</html>
<%
    }
%>
