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
    Object loggedInUser = userSession.getAttribute("user");
    if (loggedInUser != null) {
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body class="align-items-center align-content-center mt-1">
<div class="container d-flex w-75 align-items-center">
    <a href="dashboard.jsp" class="btn btn-primary flex-grow-1 m-auto">name</a>
    <a href="tickets.jps"   class="btn btn-primary flex-grow-1 m-auto">tickets</a>
    <a href="buy.jsp"       class="btn btn-primary flex-grow-1 m-auto">buy tickets</a>
    <a href="logout"    class="btn btn-primary flex-grow-1 m-auto">logout</a>
</div>
</body>
</html>
<%
    }
    else {
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body class="align-items-center align-content-center mt-1">
<div class="container d-flex w-75 align-items-center">
    <a href="login.jsp"     class="btn btn-primary flex-grow-1 m-auto">login</a>
    <a href="buy.jsp"       class="btn btn-primary flex-grow-1 m-auto">buy tickets</a>
</div>
</body>
</html>
<%
    }
%>
