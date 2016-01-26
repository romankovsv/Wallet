package web.users;

import dao.impl.MySqlUserDao;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Registration", urlPatterns = "/registration")
public class Registration extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MySqlUserDao userDao = new MySqlUserDao();
        User user = new User(request.getParameter("name"), request.getParameter("date of birth"),
                request.getParameter("sex"), request.getParameter("email"),
                request.getParameter("password"));
        if (userDao.create(user)) {
            response.sendRedirect("/");
        } else {
            request.setAttribute("error", "<font color = red>The current user is exist</font>");
            getServletContext().getRequestDispatcher("/views/registration.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
