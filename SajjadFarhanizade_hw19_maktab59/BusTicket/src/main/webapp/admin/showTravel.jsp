<%@ page import="ir.farhanizade.busticket.service.TravelService" %>
<%@ page import="ir.farhanizade.busticket.entity.Travel" %>
<%@ page import="ir.farhanizade.busticket.entity.City" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.sql.Time" %><%--
  Created by IntelliJ IDEA.
  User: farhanizade
  Date: 12/19/21
  Time: 6:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String id = request.getParameter("travel");
    Travel travel = new TravelService().loadById(Integer.parseInt(id));
    String origin = travel.getOrigin().getName();
    String destination = travel.getDestination().getName();
    LocalDate date = travel.getDate();
    Time time = travel.getTime();
%>
<jsp:include page="LoggedInTopBar.jsp"/>
<html>
<head>
    <title>Title</title>
    <link href="../css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body>
<table class="table text-center">
    <thead class="table-dark">
    <td colspan="3">Travel</td>
    </thead>
    <tbody>
    <tr>
        <td class="head">Travel ID</td>
        <td><%=id%></td>
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
        <form method="post" action="../removeTravel">
        <td colspan="2" class="head"><button type="submit" name="id" value="<%=id%>">Remove</button></td>
        </form>
    </tr>
    </tbody>
</table>
</body>
</html>
