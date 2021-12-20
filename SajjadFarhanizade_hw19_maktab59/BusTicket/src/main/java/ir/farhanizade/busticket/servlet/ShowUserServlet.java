package ir.farhanizade.busticket.servlet;

import ir.farhanizade.busticket.entity.Ticket;
import ir.farhanizade.busticket.entity.User;
import ir.farhanizade.busticket.service.TicketService;
import ir.farhanizade.busticket.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "showUser", value = "/showUser")
public class ShowUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strUserId = req.getParameter("user");
        int userId = Integer.parseInt(strUserId);
        User user = new UserService().loadById(userId);
        List<Ticket> userTickets = new TicketService().getUserTickets(user);
        req.setAttribute("user", user);
        req.setAttribute("tickets", userTickets);
        req.getRequestDispatcher("admin/showUser.jsp").forward(req, resp);
    }
}
