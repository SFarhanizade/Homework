package ir.farhanizade.busticket.servlet;

import ir.farhanizade.busticket.entity.Gender;
import ir.farhanizade.busticket.entity.User;
import ir.farhanizade.busticket.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "userSignUp", value = "/userSignUp")
public class UserSignUpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        String username = req.getParameter("username");
        if (userService.loadByUsername(username) == null) {
            String fName = req.getParameter("fName");
            String lName = req.getParameter("lName");
            String gender = req.getParameter("gender");
            String password = req.getParameter("password");
            User user = User.builder()
                    .fName(fName)
                    .lName(lName)
                    .gender(("Male".equals(gender)) ? Gender.MALE : Gender.FEMALE)
                    .username(username)
                    .password(password)
                    .build();
            userService.saveOrUpdate(user);
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
        }
        String redirect = req.getParameter("redirect");
        if (redirect != null)
            req.getRequestDispatcher(redirect).forward(req, resp);
        else
            resp.sendRedirect("index.jsp");

    }
}
