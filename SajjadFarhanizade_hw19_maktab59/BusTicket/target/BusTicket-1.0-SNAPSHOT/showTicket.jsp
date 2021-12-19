<%--
  Created by IntelliJ IDEA.
  User: farhanizade
  Date: 12/19/21
  Time: 6:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String id = request.getParameter("id");
    String name = request.getParameter("name");
    String gender = request.getParameter("gender");
    String origin = request.getParameter("origin");
    String destination = request.getParameter("destination");
    String date = request.getParameter("date");
    String time = request.getParameter("time");
    String travelId = request.getParameter("travelId");
%>
<jsp:include page="LoggedInTopBar.jsp"/>
<html>
<head>
    <title>Title</title>
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body>
<table class="table text-center">
    <thead class="table-dark">
    <td colspan="3">Ticket</td>
    </thead>
    <tbody>
    <tr>
        <td class="head">Ticket ID</td>
        <td><%=id%></td>
    </tr>
    <tr>
        <td class="head">Name</td>
        <td><%=name%></td>
    </tr>
    <tr>
        <td class="head">Gender</td>
        <td><%=gender%></td>
    </tr>
    <tr>
        <td class="head">Origin</td>
        <td><%=origin%></td>
    </tr>
    <tr>
        <td class="head">Destination</td>
        <td><%=destination%></td>
    </tr>
    <tr>
        <td class="head">Departure Date</td>
        <td><%=date%></td>
    </tr>
    <tr>
        <td class="head">Departure Time</td>
        <td><%=time%></td>
    </tr>
    <tr>
        <td class="head">Travel ID</td>
        <td><%=travelId%></td>
    </tr>
    <tr>
        <form method="post" action="cancelTicket">
        <td colspan="2" class="head"><button type="submit" name="id" value="<%=id%>">Cancel</button></td>
        </form>
    </tr>
    </tbody>
</table>
</body>
</html>
