package servlets.history;

import tables.factory.DaoFactory;
import tables.factory.MySqlDaoFactory;
import tables.transaction.History;
import tables.transaction.HistoryDao;
import tables.users.User;

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
@WebServlet(name = "Transaction", urlPatterns = "/user/history")
public class history extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoFactory daoFactory = new MySqlDaoFactory();
        User user = (User) request.getSession().getAttribute("user");
        List<History> list = new ArrayList<>();

        try (Connection connection = daoFactory.getConnection()) {
            HistoryDao historyDao = daoFactory.getTransactionDao(connection);
            list = historyDao.read(user.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("list", list);
        getServletContext().getRequestDispatcher("/history.jsp").forward(request, response);
    }
}
