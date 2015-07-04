package servlets.users;

import database.factory.DaoFactory;
import database.factory.MySqlDaoFactory;
import database.users.User;
import database.users.UserDao;
import org.apache.log4j.Logger;

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
@WebServlet(name = "ChangeData", urlPatterns = "/user/change-data")
public class ChangeData extends HttpServlet {
    public static final Logger log = Logger.getLogger(ChangeData.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoFactory daoFactory = new MySqlDaoFactory();
        User user = (User) request.getSession().getAttribute("user");

        try (Connection connection = daoFactory.getConnection()) {
            UserDao userDao = daoFactory.getUserDao(connection);
            if (userDao.update(
                    user.getId(),
                    request.getParameter("name"), request.getParameter("date"),
                    request.getParameter("sex"), request.getParameter("email"),
                    request.getParameter("password"))) {
                response.sendRedirect("/user");
            } else {
                request.setAttribute("error", "<font color = red>Current user is exist</font>");
                getServletContext().getRequestDispatcher("/changeData.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            log.error("Error during operation", e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("name", user.getName());
        request.setAttribute("date", user.getDateOfBirth());
        request.setAttribute("sex", user.getSex());
        request.setAttribute("email", user.getEmail());
        request.setAttribute("password", user.getPassword());
        getServletContext().getRequestDispatcher("/changeData.jsp").forward(request, response);
    }
}
