package web.history;

import domain.History;
import dao.impl.MySqlHistoryDao;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Transaction", urlPatterns = "/user/history")
public class HistoryList extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        List<History> list;

        MySqlHistoryDao historyDao = new MySqlHistoryDao();
        list = historyDao.readByUserId(user.getId());

        request.setAttribute("list", list);
        getServletContext().getRequestDispatcher("/views/history.jsp").forward(request, response);
    }
}
