package ir.farhanizade.busticket.servlet;

import ir.farhanizade.busticket.entity.City;
import ir.farhanizade.busticket.service.CityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addCity", value = "/addCity")
public class AddCityServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String city = req.getParameter("city");
        new CityService().saveOrUpdate(new City(city));
        resp.sendRedirect("admin/cities.jsp");
    }
}
