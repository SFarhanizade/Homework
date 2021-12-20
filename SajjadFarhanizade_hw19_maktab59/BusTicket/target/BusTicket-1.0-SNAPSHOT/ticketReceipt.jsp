<%@ page import="ir.farhanizade.busticket.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: farhanizade
  Date: 12/19/21
  Time: 5:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String travel = request.getParameter("travel");
    User user = (User) session.getAttribute("user");
    String gender = ("MALE".equals(user.getGender().toString())) ? "Mr." : "Mrs.";
    String name = user.getlName();
%>
<jsp:include page="LoggedInTopBar.jsp"/>
<html>
<head>
    <title>Title</title>
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container text-center" style="background-color: #146c43; color: #fff">
    <p><%=gender+" "+name%>, the purchase was successful.</p>
    <p>Ticket ID: <%=travel%></p>
</div>
<a href="index.jsp">
    <button class="btn btn-primary">OK</button>
</a>
</body>
</html>