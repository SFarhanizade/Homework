package ir.farhanizade.busticket.servlet;

import ir.farhanizade.busticket.entity.Admin;
import ir.farhanizade.busticket.entity.User;
import ir.farhanizade.busticket.service.AdminService;
import ir.farhanizade.busticket.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "adminLogin", value = "/adminLogin")
public class AdminLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdminService adminService = new AdminService();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Admin admin = adminService.login(username, password);
        HttpSession session = req.getSession();
        if (admin != null) {
            session.setAttribute("admin", admin);
        }
        String redirect = req.getParameter("redirect");
        if (redirect != null)
            req.getRequestDispatcher(redirect).forward(req, resp);
        else
            resp.sendRedirect("admin/index.jsp");

    }
}
