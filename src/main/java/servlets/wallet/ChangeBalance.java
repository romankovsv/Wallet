package servlets.wallet;

import database.history.MySqlHistoryDao;
import database.wallets.MySqlWalletDao;
import exception.MyException;
import org.apache.log4j.Logger;
import database.factory.DaoFactory;
import database.factory.MySqlDaoFactory;
import database.history.History;
import database.history.HistoryDao;
import database.users.User;
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
@WebServlet(name = "ChangeBalance", urlPatterns = "/user/wallet/change-balance")
public class ChangeBalance extends HttpServlet {
    private static final Logger log = Logger.getLogger(ChangeBalance.class);

    static void check(int sum, int operation) {
        if (sum + operation < 0 || operation < 0) {
            throw new MyException("Not enough money");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sum = Integer.parseInt(request.getParameter("sum"));
        int id = Integer.parseInt(request.getParameter("id"));
        int operation = Integer.parseInt(request.getParameter("operation"));
        History history = new History();
        User user = (User) request.getSession().getAttribute("user");

        try {
            MySqlWalletDao walletDao = new MySqlWalletDao();
            MySqlHistoryDao historyDao = new MySqlHistoryDao();
            check(sum, operation);
            walletDao.changeBalanceById(id, operation);

            history.setUserIdTo(user.getId());
            history.setWalletIdTo(id);
            history.setSum(operation);
            historyDao.create(history);

            response.sendRedirect("/user");
        } catch (MyException e) {
            request.setAttribute("error", "<font color = red>Not enough money</font>");
            getServletContext().getRequestDispatcher("/views/wallets/changeBalance.jsp?id=" + id
                    + "&sum=" + sum).forward(request, response);
            log.info("Not enough money");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/views/wallets/changeBalance.jsp?id=" + request.getParameter("id")
                + "&sum=" + request.getParameter("sum")).forward(request, response);
    }
}
