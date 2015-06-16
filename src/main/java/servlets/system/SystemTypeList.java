package servlets.system;

import tables.factory.DaoFactory;
import tables.factory.MySqlDaoFactory;
import tables.system.SystemType;
import tables.system.SystemTypeDao;

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
@WebServlet(name = "SystemTypeList", urlPatterns = "/system-type-list")
public class SystemTypeList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoFactory daoFactory =  new MySqlDaoFactory();
        List<SystemType> list = new ArrayList<>();

        try(Connection connection = daoFactory.getConnection()) {
            SystemTypeDao systemTypeDao = daoFactory.getSystemTypeDao(connection);
            list = systemTypeDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("list", list);
        getServletContext().getRequestDispatcher("/systemtype.jsp").forward(request, response);
    }
}
