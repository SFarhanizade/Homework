<%@ page import="ir.farhanizade.busticket.entity.Travel" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: farhanizade
  Date: 12/19/21
  Time: 3:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="LoggedInTopBar.jsp"/>
<%
    List<Travel> travels = (List<Travel>) request.getAttribute("travels");
    if (travels.size()>0) {
%>
<html>
<head>
    <title>Travels</title>
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body class="container">
<table class="table text-center w-75 m-auto">
    <thead class="table-dark">
    <td style="text-align:left"> Route: <%=travels.get(0).getOrigin().getName()%>
        - <%=travels.get(0).getDestination().getName()%>
    </td>
    <td colspan="2" style="text-align:right">Date: <%=travels.get(0).getDate().toString()%>
    </td>
    </thead>
    <thead class="table-dark mt-0">
    <td>Travel ID</td>
    <td>Departure Time</td>
    <td>Select</td>

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
            <form method="post" action="selectTicket.jsp">
                <button class="btn btn-info" type="submit" name="travel" value="<%=travel.getId()%>">Select</button>
            </form>
            </a>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>
<%
    } else{
%>
<script>window.alert('No Travels Found!');
location.replace('index.jsp');</script>
<%
    }
%>