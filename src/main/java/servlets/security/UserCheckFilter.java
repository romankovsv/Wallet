package servlets.security;

import tables.factory.DaoFactory;
import tables.factory.MySqlDaoFactory;
import tables.users.User;
import tables.users.UserDao;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
/**
 * Created by SpiritMoon
 */
public class UserCheckFilter implements javax.servlet.Filter {
    public void init(FilterConfig config) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        DaoFactory daoFactory = new MySqlDaoFactory();

        try (Connection connection = daoFactory.getConnection()) {
            UserDao userDao = daoFactory.getUserDao(connection);
            User user = userDao.login(request.getParameter("email"), request.getParameter("password"));
            if (user != null) {
                req.getSession().setAttribute("user", user);
                chain.doFilter(request, response);
            } else {
                req.setAttribute("error", "<font color=red>Wrong email/password.</font>");
                req.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {

    }
}
