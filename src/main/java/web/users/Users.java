package web.users;

import dao.impl.MySqlUserDao;
import domain.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Users", urlPatterns = "/users")
public class Users extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> list;

        MySqlUserDao userDao = new MySqlUserDao();
        list = userDao.getAll();

        request.setAttribute("list", list);
        getServletContext().getRequestDispatcher("/views/user/users.jsp").forward(request, response);
    }
}

