package ir.farhanizade.busticket.servlet;

import ir.farhanizade.busticket.entity.Travel;
import ir.farhanizade.busticket.service.TravelService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "getTickets", value = "/getTickets")
public class FindTravelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("".equals(req.getParameter("origin"))
                || "".equals(req.getParameter("destination"))
                || "".equals(req.getParameter("date"))) {
            resp.sendRedirect("index.jsp");
        }else {
            int origin = Integer.parseInt(req.getParameter("origin"));
            int destination = Integer.parseInt(req.getParameter("destination"));
            String date = req.getParameter("date");
            LocalDate localDate = LocalDate.parse(date);
            TravelService travelService = new TravelService();
            List<Travel> travels = travelService.getTravels(origin, destination, localDate);
            req.setAttribute("travels", travels);
            req.getRequestDispatcher("showTravels.jsp").forward(req, resp);
        }
    }
}
