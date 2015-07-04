package servlets.users;

import org.apache.log4j.Logger;
import database.factory.DaoFactory;
import database.factory.MySqlDaoFactory;
import database.users.User;
import database.users.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
/**
 * Created by SpiritMoon
 */
@WebServlet(name = "Registration", urlPatterns = "/registration")
public class Registration extends HttpServlet {
    private static final Logger log = Logger.getLogger(Registration.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoFactory daoFactory = new MySqlDaoFactory();

        try (Connection connection = daoFactory.getConnection()) {
            UserDao userDao = daoFactory.getUserDao(connection);
            User user = new User(request.getParameter("name"), request.getParameter("date of birth"),
                    request.getParameter("sex"), request.getParameter("email"),
                    request.getParameter("password"));
            if (userDao.create(user)) {
                response.sendRedirect("/");
            } else {
                request.setAttribute("error", "<font color = red>The current user is exist</font>");
                getServletContext().getRequestDispatcher("/registration.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            log.error("Error in operation", e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
