package ir.farhanizade.busticket.servlet;

import ir.farhanizade.busticket.Main;
import ir.farhanizade.busticket.entity.User;
import ir.farhanizade.busticket.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userService.login(username, password);
        HttpSession session = req.getSession();
        if (user != null) {
            session.setAttribute("user", user);
        }
        String redirect = req.getParameter("redirect");
        if (redirect != null)
            req.getRequestDispatcher(redirect).forward(req, resp);
        else
            resp.sendRedirect("index.jsp");

    }
}
