package servlets.users;

import database.wallets.MySqlWalletDao;
import org.apache.log4j.Logger;
import database.users.User;
import database.wallets.Wallet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        List<Wallet> list;
        User user = (User) request.getSession().getAttribute("user");

        MySqlWalletDao walletDao = new MySqlWalletDao();
        list = walletDao.readForUserById(user.getId());

        request.setAttribute("list", list);
        getServletContext().getRequestDispatcher("/views/user/userMainPage.jsp").forward(request, response);
    }
}
