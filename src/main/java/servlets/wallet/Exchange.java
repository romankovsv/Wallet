package servlets.wallet;

import tables.factory.DaoFactory;
import tables.factory.MySqlDaoFactory;
import tables.wallets.Wallet;
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
@WebServlet(name = "Exchange", urlPatterns = "/user/wallet/exchange")
public class Exchange extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoFactory daoFactory = new MySqlDaoFactory();
        int fromId = Integer.parseInt(request.getParameter("firstId"));
        int toId = Integer.parseInt(request.getParameter("secondId"));
        int sum = Integer.parseInt(request.getParameter("sum"));

        try (Connection connection = daoFactory.getConnection()) {
            WalletDao walletDao = daoFactory.getWalletDao(connection);
            walletDao.exchange(fromId, toId, sum);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/user");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/exchange.jsp").forward(request, response);
    }
}
