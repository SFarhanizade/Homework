<%@ page import="ir.farhanizade.busticket.entity.Travel" %>
<%@ page import="java.util.List" %>
<%@ page import="ir.farhanizade.busticket.service.TravelService" %>
<%@ page import="ir.farhanizade.busticket.entity.City" %>
<%@ page import="ir.farhanizade.busticket.service.CityService" %><%--
  Created by IntelliJ IDEA.
  User: farhanizade
  Date: 12/19/21
  Time: 3:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="LoggedInTopBar.jsp"/>
<%
    List<Travel> travels = new TravelService().loadAll();
    CityService cityService = new CityService();
    List<City> cities = cityService.loadAll();
    if (travels.size() > 0) {
%>
<html>
<head>
    <title>Travels</title>
    <link href="../css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body class="container">
<table class="table text-center w-75 m-auto">
    <thead class="table-dark mt-0">
    <td>Travel ID</td>
    <td>Departure Time</td>
    <td>Details</td>

    </thead>
    <tbody>
    <%
        for (Travel travel : travels) {
    %>
    <tr>
        <td><%=travel.getId()%>
        </td>
        <td><%=travel.getTime()%>
        </td>
        <td>
            <form method="post" action="showTravel.jsp">
                <button class="btn btn-info" type="submit" name="travel" value="<%=travel.getId()%>">Details</button>
            </form>
            </a>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<%
} else {
%>
<script>window.alert('No Travels Found!');</script>
<%
    }
%>
<div class="w-75 m-auto">
    <p>Add a new Travel</p>
    <form class="d-flex flex-wrap" method="post" action="../addTravel">
        <div class="flex-grow-1" style="margin-right: 1rem">
            <p style="margin: 0">Origin</p>
            <select class="form-select " aria-label="Default select example" name="origin">
                <option value="" selected>Choose origin</option>
                <%
                    for (City city : cities) {
                %>
                <option value="<%=city.getId()%>"><%=city.getName()%>
                </option>
                <%
                    }
                %>
            </select>
        </div>
        <div class="flex-grow-1" style="margin-right: 1rem">
            <p style="margin: 0">Destination</p>
            <select class="form-select" aria-label="Default select example" name="destination">
                <option value="" selected>Choose destination</option>
                <%
                    for (City city : cities) {
                %>
                <option value="<%=city.getId()%>"><%=city.getName()%>
                </option>
                <%
                    }
                %>
            </select>
        </div>
        <div class="flex-grow-1" style="margin-right: 1rem">
            <p style="margin: 0">Date</p>
            <input class=" form-control" type="date" name="date"/>
        </div>
        <div class="flex-grow-1" style="margin-right: 1rem">
            <p style="margin: 0">Time</p>
            <input class=" form-control" type="time" name="time"/>
        </div>
        <button class="btn btn-success mt-4 flex-grow-1" type="submit">Add</button>
    </form>
</div>
</body>
</html>
