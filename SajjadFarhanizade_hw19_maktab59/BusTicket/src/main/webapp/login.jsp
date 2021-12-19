<%--
  Created by IntelliJ IDEA.
  User: farhanizade
  Date: 12/19/21
  Time: 12:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Object user = session.getAttribute("user");
    if (user == null) {
        Object travel = request.getAttribute("travel");
        Object redirect = request.getAttribute("redirect");
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300&display=swap" rel="stylesheet">
    <link href="css/login.css" type="text/css" rel="stylesheet">
</head>
<body>

<div class="login">
    <form method="post"
          action="login
          <%= (redirect==null)?"":"?redirect="+redirect%><%= (travel==null)?"":"&travel="+travel%>">
        <label class="login-text">Login</label>
        <input type="text" class="input" placeholder="Username" name="username"/>
        <input type="text" class="input" placeholder="Password" name="password"/>
        <input type="submit">
    </form>
</div>

</body>
</html>
<%
    } else {
        response.sendRedirect("index.jsp");
    }
%>
