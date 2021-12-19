package ir.farhanizade.busticket.servlet;

import ir.farhanizade.busticket.service.TicketService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "cancelTicket", value = "/cancelTicket")
public class CancelTicketServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        new TicketService().remove(id);
        PrintWriter writer = resp.getWriter();
        writer.println("<script>window.alert('Removed!');" +
                "location.replace('index.jsp');</script>");
    }
}
