<%@ page import="ir.farhanizade.busticket.service.CityService" %>
<%@ page import="ir.farhanizade.busticket.entity.City" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: farhanizade
  Date: 12/19/21
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    CityService cityService = new CityService();
    List<City> cities = cityService.loadAll();
%>
<html>
<head>
    <link href="css/bootstrap.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="container mb-2">
    <form class="d-flex flex-wrap" method="get" action="getTickets">
        <div class="flex-grow-1" style="margin-right: 1rem">
            <p style="margin: 0">Origin</p>
            <select class="form-select " aria-label="Default select example" name="origin">
                <option selected>Choose origin</option>
                <%
                    for (City city: cities){
                %>
                <option value="<%=city.getId()%>"><%=city.getName()%></option>
                <%
                    }
                %>
            </select>
        </div>
        <div class="flex-grow-1" style="margin-right: 1rem">
            <p style="margin: 0">Destination</p>
            <select class="form-select" aria-label="Default select example" name="destination">
                <option selected>Choose destination</option>
                <%
                    for (City city: cities){
                %>
                <option value="<%=city.getId()%>"><%=city.getName()%></option>
                <%
                    }
                %>
            </select>
        </div>
        <div class="flex-grow-1" style="margin-right: 1rem">
            <p style="margin: 0">Date</p>
            <input class=" form-control" type="date" name="date"/>
        </div>
        <button class="btn btn-success mt-4 flex-grow-1" type="submit">search</button>
    </form>
</div>
</body>
</html>
