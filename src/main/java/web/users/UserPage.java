package web.users;

import dao.wallets.MySqlWalletDao;
import domain.User;
import domain.Wallet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserPage", urlPatterns = "/user")
public class UserPage extends HttpServlet {
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
