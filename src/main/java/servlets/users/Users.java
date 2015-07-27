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
import java.util.List;
/**
 * Created by SpiritMoon
 */
@WebServlet(name = "Users", urlPatterns = "/users")
public class Users extends HttpServlet {
    private static final Logger log = Logger.getLogger(Users.class);

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

