package servlets.system;

import database.system.MySqlSystemTypeDao;
import database.system.SystemType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SystemTypeList", urlPatterns = "/system-type-list")
public class SystemTypeList extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SystemType> list;

        MySqlSystemTypeDao systemTypeDao = new MySqlSystemTypeDao();
        list = systemTypeDao.getAll();

        request.setAttribute("list", list);
        getServletContext().getRequestDispatcher("/views/system/systemTypes.jsp").forward(request, response);
    }
}
