package web.wallet;

import dao.wallets.MySqlWalletDao;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateWallet", urlPatterns = "/user/new-wallet/create")
public class CreateWallet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        int walletId = Integer.parseInt(request.getParameter("type"));
        int currencyId = Integer.parseInt(request.getParameter("currency"));

        MySqlWalletDao walletDao = new MySqlWalletDao();
        walletDao.createForUserById(user.getId(), walletId, currencyId);

        response.sendRedirect("/user");
    }
}
