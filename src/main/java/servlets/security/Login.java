package servlets.security;

import database.users.MySqlUserDao;
import org.apache.log4j.Logger;
import database.users.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Created by SpiritMoon
 */
@WebServlet(name = "Login", urlPatterns = "/login")
public class Login extends HttpServlet {
    private static final Logger log = Logger.getLogger(Login.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MySqlUserDao userDao = new MySqlUserDao();
        User user = userDao.login(request.getParameter("email"), request.getParameter("password"));
        if (user != null) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/user");
        } else {
            request.setAttribute("error", "<font color=red>Wrong email/password.</font>");
            getServletContext().getRequestDispatcher("/").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
