package ir.farhanizade.busticket.servlet;

import ir.farhanizade.busticket.entity.Gender;
import ir.farhanizade.busticket.entity.Ticket;
import ir.farhanizade.busticket.entity.Travel;
import ir.farhanizade.busticket.entity.User;
import ir.farhanizade.busticket.service.TicketService;
import ir.farhanizade.busticket.service.TravelService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "buyTicket", value = "/buyTicket")
public class BuyTicketServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String strTravel = req.getParameter("travel");
        String fName = req.getParameter("fName");
        String lName = req.getParameter("lName");
        String gender = req.getParameter("gender");
        if("".equals(fName) || "".equals(lName) || gender==null){
            resp.sendRedirect("index.jsp");
        }
        else {
            user.setfName(fName);
            user.setlName(lName);
            user.setGender((gender.equals("Male") ? Gender.MALE : Gender.FEMALE));
            int travelId = Integer.parseInt(strTravel);
            Travel travel = new TravelService().loadById(travelId);
            Ticket ticket = Ticket.builder()
                    .owner(user)
                    .travel(travel)
                    .build();
            new TicketService().saveOrUpdate(ticket);
            req.getRequestDispatcher("ticketReceipt.jsp").forward(req, resp);
        }
    }
}
