<%@ page import="java.util.List" %>
<%@ page import="ir.farhanizade.busticket.entity.*" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.sql.Time" %>
<%@ page import="ir.farhanizade.busticket.service.TicketService" %><%--
  Created by IntelliJ IDEA.
  User: farhanizade
  Date: 12/19/21
  Time: 6:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="LoggedInTopBar.jsp"/>
<%
    User user = (User) session.getAttribute("user");

    List<Ticket> tickets = new TicketService().getUserTickets(user);
    if (tickets != null) {
%>
<html>
<head>
    <title>Title</title>
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body class="container">
<table class="table text-center w-75 m-auto">
    <thead class="table-dark">
    <td colspan="3">Tickets</td>
    </thead>
    <thead class="table-dark mt-0">
    <td>Select</td>
    <td>Ticket ID</td>
    <td>Date</td>

    </thead>
    <tbody>
    <%
        for (Ticket ticket : tickets) {
            Integer id = ticket.getId();
            User owner = ticket.getOwner();
            String ownerName = owner.getfName() + " " + owner.getlName();
            Gender gender = owner.getGender();
            Travel travel = ticket.getTravel();
            String origin = travel.getOrigin().getName();
            String destination = travel.getDestination().getName();
            LocalDate date = travel.getDate();
            Time time = travel.getTime();
            Integer travelId = travel.getId();
            String parameters = "id=" + id + "&name=" + ownerName + "&gender=" + gender + "&origin=" + origin
                    + "&destination=" + destination + "&date=" + date + "&time=" + time + "&travelId=" + travelId;
    %>
    <tr>
        <td>
            <form method="post" action="showTicket.jsp?<%=parameters%>">
                <button type="submit">Details</button>
            </form>
        </td>
        <td><%=ticket.getId()%>
        </td>
        <td><%=ticket.getTravel().getDate()%>
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
    }
%>