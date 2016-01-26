package web.users;

import dao.impl.MySqlUserDao;
import dao.impl.MySqlWalletDao;
import org.apache.log4j.Logger;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Created by SpiritMoon
 */
@WebServlet(name = "DeleteAccount" , urlPatterns = "/user/delete-account")
public class DeleteAccount extends HttpServlet {
    private static final Logger log = Logger.getLogger(DeleteAccount.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");

        MySqlWalletDao walletDao = new MySqlWalletDao();
        MySqlUserDao userDao = new MySqlUserDao();
        walletDao.deleteUserWalletById(user.getId());
        userDao.delete(user.getId());
        response.sendRedirect("/");
    }
}
