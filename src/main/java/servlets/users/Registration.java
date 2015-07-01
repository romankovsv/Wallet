package servlets.users;

import org.apache.log4j.Logger;
import tables.factory.DaoFactory;
import tables.factory.MySqlDaoFactory;
import tables.users.User;
import tables.users.UserDao;

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
            userDao.create(user);
        } catch (SQLException e) {
            log.error(e);
        }
        response.sendRedirect("/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
