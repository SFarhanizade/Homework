<%--
  Created by IntelliJ IDEA.
  User: farhanizade
  Date: 12/19/21
  Time: 4:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String travel = request.getParameter("travel");
    Object user = session.getAttribute("user");
    if (user == null) {
        request.setAttribute("travel",travel);
        request.setAttribute("redirect", "selectTicket.jsp");
        request.getRequestDispatcher("login.jsp").forward(request, response);
    } else {
%>
<jsp:include page="LoggedInTopBar.jsp"/>
<html>
<head>
    <title>Title</title>
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body>
<form class="container d-flex flex-wrap" method="post" action="buyTicket?travel=<%=travel%>">
    <div class="flex-grow-1 mt-1">
        <lable class="flex-grow-1" for="fName">First Name</lable>
        <input class="flex-grow-1" type="text" name="fName"/>
    </div>
    <div class="flex-grow-1 mt-1">
        <lable class="flex-grow-1" for="lName">Last Name</lable>
        <input class="flex-grow-1" type="text" name="lName"/>
    </div>
    <div class="flex-grow-1 mt-1">
        <label class="flex-grow-1" for="Male">Male</label>
        <input class="flex-grow-1" type="radio" id="Male" name="gender" value="Male">
        <label class="flex-grow-1" for="Female">Female</label>
        <input class="flex-grow-1" type="radio" id="Female" name="gender" value="Female">
    </div>
    <button class="flex-grow-1 btn btn-primary mt-1" type="submit">Submit</button>
</form>
</body>
</html>
<%
    }
%>