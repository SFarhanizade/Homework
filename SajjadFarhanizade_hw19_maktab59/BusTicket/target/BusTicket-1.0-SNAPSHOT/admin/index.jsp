<%@ page import="ir.farhanizade.busticket.Main" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%HttpSession userSession = request.getSession();
Object loggedInUser = userSession.getAttribute("admin");
if (loggedInUser == null) {
    response.sendRedirect("login.jsp");
}
%>
<jsp:include page="LoggedInTopBar.jsp"/>
