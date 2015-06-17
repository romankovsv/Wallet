package servlets.login;

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
import java.sql.*;
/**
 * Created by SpiritMoon
 */
@WebServlet(name = "Login", urlPatterns = "/login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoFactory daoFactory = new MySqlDaoFactory();

        try (Connection connection = daoFactory.getConnection()) {
            UserDao userDao = daoFactory.getUserDao(connection);
            User user = userDao.login(request.getParameter("email"), request.getParameter("password"));
            if (user != null) {
                request.getSession().setAttribute("id", user.getId());
                request.getSession().setAttribute("name", user.getName());
                response.sendRedirect("/user");
            } else {
                response.sendError(401);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
