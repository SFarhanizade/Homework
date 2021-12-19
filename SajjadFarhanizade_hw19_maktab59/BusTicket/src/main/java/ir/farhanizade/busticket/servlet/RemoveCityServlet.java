package ir.farhanizade.busticket.servlet;

import ir.farhanizade.busticket.service.CityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "removeCity", value = "/removeCity")
public class RemoveCityServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer city = Integer.parseInt(req.getParameter("city"));
        new CityService().remove(city);
        PrintWriter writer = resp.getWriter();
        writer.println("<script>window.alert('Removed!');" +
                "location.replace('admin/index.jsp');</script>");
    }
}
