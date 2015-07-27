package servlets.history;

import database.history.History;
import database.history.MySqlHistoryDao;
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
@WebServlet(name = "Transaction", urlPatterns = "/user/history")
public class HistoryList extends HttpServlet {
    private static final Logger log = Logger.getLogger(HistoryList.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        List<History> list;

        MySqlHistoryDao historyDao = new MySqlHistoryDao();
        list = historyDao.readByUserId(user.getId());

        request.setAttribute("list", list);
        getServletContext().getRequestDispatcher("/views/user/history.jsp").forward(request, response);
    }
}
