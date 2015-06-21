package servlets.users;

import tables.factory.DaoFactory;
import tables.factory.MySqlDaoFactory;
import tables.users.User;
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
import java.util.ArrayList;
import java.util.List;
/**
 * Created by SpiritMoon
 */
@WebServlet(name = "UserPage", urlPatterns = "/user")
public class UserPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoFactory daoFactory = new MySqlDaoFactory();
        List<Wallet> list = new ArrayList<>();
        User user = (User) request.getSession().getAttribute("user");

        try (Connection connection = daoFactory.getConnection()) {
            WalletDao walletDao = daoFactory.getWalletDao(connection);
            list = walletDao.getAll(user.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("list", list);
        getServletContext().getRequestDispatcher("/userMainPage.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
