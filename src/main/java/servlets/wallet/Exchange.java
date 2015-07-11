package servlets.wallet;

import org.apache.log4j.Logger;
import database.factory.DaoFactory;
import database.factory.MySqlDaoFactory;
import database.transaction.History;
import database.transaction.HistoryDao;
import database.users.User;
import database.wallets.Wallet;
import database.wallets.WalletDao;

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
@WebServlet(name = "Exchange", urlPatterns = "/user/wallet/exchange")
public class Exchange extends HttpServlet {
    private static final Logger log = Logger.getLogger(Exchange.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoFactory daoFactory = new MySqlDaoFactory();
        int fromId = Integer.parseInt(request.getParameter("firstId"));
        int toId = Integer.parseInt(request.getParameter("secondId"));
        int sum = Integer.parseInt(request.getParameter("sum"));
        History history = new History();
        User user = (User) request.getSession().getAttribute("user");
        boolean complete = false;

        try (Connection connection = daoFactory.getConnection()) {
            WalletDao walletDao = daoFactory.getWalletDao(connection);
            for (Wallet walletFrom : walletDao.readByUserId(user.getId())) {
                if ((walletFrom.getId() == fromId) && (walletFrom.getSum() - sum >= 0)) {
                    for (Wallet walletTo : walletDao.getAll()) {
                        if (walletTo.getId() == toId) {
                            walletDao.exchange(fromId, toId, sum);

                            int userIdTo = walletDao.readByWalletId(toId).getUserId();

                            HistoryDao historyDao = daoFactory.getTransactionDao(connection);
                            history.setUserIdFrom(user.getId());
                            history.setUserIdTo(userIdTo);
                            history.setWalletIdFrom(fromId);
                            history.setWalletIdTo(toId);
                            history.setSum(sum);
                            historyDao.create(history);

                            complete = true;
                            response.sendRedirect("/user");
                        }
                    }
                }
            }
        } catch (SQLException e) {
            log.error("Error in operation", e);
        }

        if (!complete) {
            request.setAttribute("error", "<font color = red>Wrong data</font>");
            getServletContext().getRequestDispatcher("/exchange.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/exchange.jsp").forward(request, response);
    }
}
