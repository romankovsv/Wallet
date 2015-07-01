package servlets.wallet;

import org.apache.log4j.Logger;
import tables.factory.DaoFactory;
import tables.factory.MySqlDaoFactory;
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
@WebServlet(name = "CreateWallet", urlPatterns = "/user/new-wallet/create")
public class CreateWallet extends HttpServlet {
    private static final Logger log = Logger.getLogger(CreateWallet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoFactory daoFactory = new MySqlDaoFactory();
        User user = (User) request.getSession().getAttribute("user");
        int walletId = Integer.parseInt(request.getParameter("type"));
        int currencyId = Integer.parseInt(request.getParameter("currency"));

        try (Connection connection = daoFactory.getConnection()) {
            WalletDao walletDao = daoFactory.getWalletDao(connection);
            walletDao.create(user.getId(), walletId, currencyId);
        } catch (SQLException e) {
            log.error(e);
        }

        response.sendRedirect("/user");
    }
}
