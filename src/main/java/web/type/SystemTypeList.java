package web.type;

import dao.impl.MySqlTypeDao;
import domain.Type;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SystemTypeList", urlPatterns = "/type-type-list")
public class SystemTypeList extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Type> list;

        MySqlTypeDao systemTypeDao = new MySqlTypeDao();
        list = systemTypeDao.getAll();

        request.setAttribute("list", list);
        getServletContext().getRequestDispatcher("/views/types.jsp").forward(request, response);
    }
}
