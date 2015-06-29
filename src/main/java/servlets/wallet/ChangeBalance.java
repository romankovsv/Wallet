package servlets.wallet;

import tables.factory.DaoFactory;
import tables.factory.MySqlDaoFactory;
import tables.transaction.History;
import tables.transaction.HistoryDao;
import tables.users.User;
import tables.wallets.WalletDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
/**
 * Created by SpiritMoon
 */
@WebServlet(name = "ChangeBalance", urlPatterns = "/user/wallet/change-balance")
public class ChangeBalance extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoFactory daoFactory = new MySqlDaoFactory();
        int sum = Integer.parseInt(request.getParameter("sum"));
        int id = Integer.parseInt(request.getParameter("id"));
        History history = new History();
        User user = (User) request.getSession().getAttribute("user");

        try (Connection connection = daoFactory.getConnection()) {
            WalletDao walletDao = daoFactory.getWalletDao(connection);
            walletDao.changeBalance(id, sum);

            HistoryDao historyDao = daoFactory.getTransactionDao(connection);
            history.setUserIdTo(user.getId());
            history.setWalletIdTo(id);
            history.setSum(sum);
            historyDao.create(history);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/user");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/changeBalance.jsp?id=" + request.getParameter("id") + "").forward(request, response);
    }
}
