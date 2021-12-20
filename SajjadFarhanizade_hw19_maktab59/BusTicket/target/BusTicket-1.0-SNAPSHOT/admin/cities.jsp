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
    List<City> cities = new CityService().loadAll();
    if (cities.size()>0) {
%>
<html>
<head>
    <title>Cities</title>
    <link href="../css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body class="container d-flex w-75 align-items-center">
<table class="table text-center w-75 flex-grow-1 m-auto">
    <thead class="table-dark mt-0">
    <td>City ID</td>
    <td>Name</td>
    <td>Remove</td>

    </thead>
    <tbody>
    <%
        for (City city : cities) {
    %>
    <tr>
        <td><%=city.getId()%>
        </td>
        <td><%=city.getName()%>
        </td>
        <td>
            <form method="post" action="../removeCity">
                <button class="btn btn-info" type="submit" name="city" value="<%=city.getId()%>">Remove</button>
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
} else{
%>
<script>window.alert('No Cities Found!');</script>
<%
    }
%>
<div class="w-75">
<p>Add a new City</p>
<form class="form" method="post" action="../addCity">
    <label for="city">City</label>
    <input id="city" name="city" type="text">
    <button type="submit">Add</button>
</form>
</div>
</body>
</html>
