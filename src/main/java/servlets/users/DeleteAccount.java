package servlets.users;

import org.apache.log4j.Logger;
import database.factory.DaoFactory;
import database.factory.MySqlDaoFactory;
import database.users.User;
import database.users.UserDao;
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
@WebServlet(name = "DeleteAccount" , urlPatterns = "/user/delete-account")
public class DeleteAccount extends HttpServlet {
    private static final Logger log = Logger.getLogger(DeleteAccount.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoFactory daoFactory = new MySqlDaoFactory();
        User user = (User) request.getSession().getAttribute("user");

        try (Connection connection = daoFactory.getConnection()) {
            WalletDao walletDao = daoFactory.getWalletDao(connection);
            UserDao userDao = daoFactory.getUserDao(connection);
            walletDao.deleteUserWalletById(user.getId());
            userDao.delete(user.getId());
            response.sendRedirect("/");
        } catch (SQLException e) {
            log.error("Error in operation", e);
        }
    }
}
