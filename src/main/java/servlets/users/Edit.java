package servlets.users;

import database.users.MySqlUserDao;
import database.users.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Created by SpiritMoon
 */
@WebServlet(name = "Edit", urlPatterns = "/user/edit")
public class Edit extends HttpServlet {
    public static final Logger log = Logger.getLogger(Edit.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");

        MySqlUserDao userDao = new MySqlUserDao();
        if (userDao.update(
                user.getId(),
                request.getParameter("name"), request.getParameter("date"),
                request.getParameter("sex"), request.getParameter("email"),
                request.getParameter("password"))) {
            response.sendRedirect("/user");
        } else {
            request.setAttribute("error", "<font color = red>Current user is exist</font>");
            getServletContext().getRequestDispatcher("/views/user/edit.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/views/user/edit.jsp").forward(request, response);
    }
}
