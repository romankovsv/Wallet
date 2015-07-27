package servlets.system;

import database.system.MySqlSystemTypeDao;
import org.apache.log4j.Logger;
import database.system.SystemType;

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
@WebServlet(name = "DeleteSystemType", urlPatterns = "/deleteById-system-type")
public class DeleteSystemType extends HttpServlet {
    private static final Logger log = Logger.getLogger(DeleteSystemType.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SystemType> list;

        MySqlSystemTypeDao systemTypeDao = new MySqlSystemTypeDao();
        list = systemTypeDao.getAll();

        request.setAttribute("list", list);
        getServletContext().getRequestDispatcher("/views/system/systemTypes.jsp").forward(request, response);
    }
}
