package servlets.wallet;

import tables.factory.DaoFactory;
import tables.factory.MySqlDaoFactory;
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
@WebServlet(name = "DeleteWallet", urlPatterns = "/user/delete-wallet")
public class DeleteWallet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoFactory daoFactory = new MySqlDaoFactory();

        try (Connection connection = daoFactory.getConnection()) {
            WalletDao walletDao = daoFactory.getWalletDao(connection);
            int id = Integer.parseInt(request.getParameter("id"));
            walletDao.delete(id);
            response.sendRedirect("/user");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
