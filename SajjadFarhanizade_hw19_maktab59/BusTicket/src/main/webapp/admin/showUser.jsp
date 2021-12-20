<%@ page import="ir.farhanizade.busticket.entity.User" %>
<%@ page import="ir.farhanizade.busticket.entity.Ticket" %>
<%@ page import="java.util.List" %>
<%@ page import="ir.farhanizade.busticket.entity.Gender" %>
<%@ page import="ir.farhanizade.busticket.entity.Travel" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.sql.Time" %><%--
  Created by IntelliJ IDEA.
  User: farhanizade
  Date: 12/19/21
  Time: 6:37 PM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="LoggedInTopBar.jsp"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User)request.getAttribute("user");
    List<Ticket> tickets = (List<Ticket>)request.getAttribute("tickets");
%>

<html>
<head>
    <title>Title</title>
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body class="container">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<div class="accordion accordion-flush w-75 m-auto" id="accordionFlushExample">
    <div class="accordion-item">
        <h2 class="accordion-header" id="flush-headingOne">
            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
                User Information
            </button>
        </h2>
        <div id="flush-collapseOne" class="accordion-collapse collapse" aria-labelledby="flush-headingOne" data-bs-parent="#accordionFlushExample">
            <div class="accordion-body">
                <table class="table text-center">
                    <tbody>
                    <tr>
                        <td class="head">User ID</td>
                        <td><%=user.getId() %></td>
                    </tr>
                    <tr>
                        <td class="head">First Name</td>
                            <td>
                                <%=user.getfName()%>
                            </td>
                    </tr>
                    <tr>
                        <td class="head">Last Name</td>
                        <td><%=user.getlName()%>
                        </td>
                    </tr>
                    <tr>
                        <td class="head">Gender</td>
                        <td><%=user.getGender()%>
                        </td>
                    </tr>
                    <tr>
                        <td class="head">Username</td>
                        <td><%=user.getUsername()%>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="accordion-item">
        <h2 class="accordion-header" id="flush-headingTwo">
            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo" aria-expanded="false" aria-controls="flush-collapseTwo">
                Tickets
            </button>
        </h2>
        <div id="flush-collapseTwo" class="accordion-collapse collapse" aria-labelledby="flush-headingTwo" data-bs-parent="#accordionFlushExample">
            <div class="accordion-body">
                <table class="table text-center">
                    <thead class="table-dark mt-0">
                    <td>Select</td>
                    <td>Ticket ID</td>
                    <td>Date</td>

                    </thead>
                    <tbody>
                    <%
                        for (Ticket ticket : tickets) {
                            Integer id = ticket.getId();
                            String ownerName = user.getfName() + " " + user.getlName();
                            Gender gender = user.getGender();
                            Travel travel = ticket.getTravel();
                            String origin = travel.getOrigin().getName();
                            String destination = travel.getDestination().getName();
                            LocalDate date = travel.getDate();
                            Time time = travel.getTime();
                            Integer travelId = travel.getId();
                            String parameters = "id=" + id + "&name=" + ownerName + "&ownerId=" + user.getId() + "&gender=" + gender + "&origin=" + origin
                                    + "&destination=" + destination + "&date=" + date + "&time=" + time + "&travelId=" + travelId;
                    %>
                    <tr>
                        <td>
                            <form method="post" action="admin/showTicket.jsp?<%=parameters%>">
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
            </div>
        </div>
    </div>
</div>
</body>
</html>
