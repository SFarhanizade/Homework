package ir.farhanizade.busticket.servlet;

import ir.farhanizade.busticket.entity.City;
import ir.farhanizade.busticket.entity.Travel;
import ir.farhanizade.busticket.service.CityService;
import ir.farhanizade.busticket.service.TravelService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@WebServlet(name = "addTravel", value = "/addTravel")
public class AddTravelServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer originId = Integer.parseInt(req.getParameter("origin"));
        Integer destinationId = Integer.parseInt(req.getParameter("destination"));
        String strDate = req.getParameter("date");
        String strTime = req.getParameter("time");
        CityService cityService = new CityService();
        City origin = cityService.loadById(originId);
        City destination = cityService.loadById(destinationId);
        LocalDate date = LocalDate.parse(strDate);
        LocalTime time = LocalTime.parse(strTime);
        Travel travel = Travel.builder()
                .origin(origin)
                .destination(destination)
                .date(date)
                .time(Time.valueOf(time))
                .build();
        new TravelService().saveOrUpdate(travel);
        resp.sendRedirect("admin/travels.jsp");
    }
}
