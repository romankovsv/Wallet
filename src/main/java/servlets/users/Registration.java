package servlets.users;

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
@WebServlet(name = "Registration", urlPatterns = "/registration")
public class Registration extends HttpServlet {
    private static final Logger log = Logger.getLogger(Registration.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MySqlUserDao userDao = new MySqlUserDao();
        User user = new User(request.getParameter("name"), request.getParameter("date of birth"),
                request.getParameter("sex"), request.getParameter("email"),
                request.getParameter("password"));
        if (userDao.create(user)) {
            response.sendRedirect("/");
        } else {
            request.setAttribute("error", "<font color = red>The current user is exist</font>");
            getServletContext().getRequestDispatcher("/views/user/registration.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
