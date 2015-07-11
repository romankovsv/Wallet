package servlets.system;

import org.apache.log4j.Logger;
import database.factory.DaoFactory;
import database.factory.MySqlDaoFactory;
import database.system.SystemType;
import database.system.SystemTypeDao;

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
    private static final Logger log = Logger.getLogger(SystemTypeList.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoFactory daoFactory =  new MySqlDaoFactory();
        List<SystemType> list = new ArrayList<>();

        try(Connection connection = daoFactory.getConnection()) {
            SystemTypeDao systemTypeDao = daoFactory.getSystemTypeDao(connection);
            list = systemTypeDao.getAll();
        } catch (SQLException e) {
            log.error("Error in operation", e);
        }

        request.setAttribute("list", list);
        getServletContext().getRequestDispatcher("/views/system/systemTypes.jsp").forward(request, response);
    }
}
