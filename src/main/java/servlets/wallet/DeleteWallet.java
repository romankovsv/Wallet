package servlets.wallet;

import database.wallets.MySqlWalletDao;
import org.apache.log4j.Logger;
import database.factory.DaoFactory;
import database.factory.MySqlDaoFactory;
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
@WebServlet(name = "DeleteWallet", urlPatterns = "/user/delete-wallet")
public class DeleteWallet extends HttpServlet {
    private static final Logger log = Logger.getLogger(DeleteWallet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        MySqlWalletDao walletDao = new MySqlWalletDao();
        walletDao.deleteById(id);
        response.sendRedirect("/user");
    }
}
