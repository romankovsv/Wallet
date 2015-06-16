package servlets.users;

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
import java.util.ArrayList;
import java.util.List;
/**
 * Created by SpiritMoon
 */
@WebServlet(name = "UsersList", urlPatterns = "/users")
public class UserList extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoFactory daoFactory = new MySqlDaoFactory();
        List<User> list = new ArrayList<>();

        try(Connection connection = daoFactory.getConnection()) {
            UserDao userDao = daoFactory.getUserDao(connection);
            list = userDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("list", list);
        getServletContext().getRequestDispatcher("/users.jsp").forward(request, response);
    }
}

