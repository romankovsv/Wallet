package servlets.users;

import tables.factory.DaoFactory;
import tables.factory.MySqlDaoFactory;
import tables.users.User;
import tables.users.UserDao;
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
@WebServlet(name = "DeleteAccount" , urlPatterns = "/user/delete-account")
public class DeleteAccount extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoFactory daoFactory = new MySqlDaoFactory();
        User user = (User) request.getSession().getAttribute("user");

        try (Connection connection = daoFactory.getConnection()) {
            WalletDao walletDao = daoFactory.getWalletDao(connection);
            UserDao userDao = daoFactory.getUserDao(connection);
            walletDao.deleteUserWallets(user.getId());
            userDao.delete(user.getId());
            response.sendRedirect("/");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
