package servlets.users;

import org.apache.log4j.Logger;
import database.factory.DaoFactory;
import database.factory.MySqlDaoFactory;
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
import java.util.ArrayList;
import java.util.List;
/**
 * Created by SpiritMoon
 */
@WebServlet(name = "UserPage", urlPatterns = "/user")
public class UserPage extends HttpServlet {
    private static final Logger log = Logger.getLogger(UserPage.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoFactory daoFactory = new MySqlDaoFactory();
        List<Wallet> list = new ArrayList<>();
        User user = (User) request.getSession().getAttribute("user");

        try (Connection connection = daoFactory.getConnection()) {
            WalletDao walletDao = daoFactory.getWalletDao(connection);
            list = walletDao.readByUserId(user.getId());
        } catch (SQLException e) {
            log.error("Error in operation", e);
        }

        request.setAttribute("list", list);
        getServletContext().getRequestDispatcher("/userMainPage.jsp").forward(request, response);
    }
}
