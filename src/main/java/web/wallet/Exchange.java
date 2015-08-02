package web.wallet;

import dao.history.MySqlHistoryDao;
import dao.wallets.MySqlWalletDao;
import domain.History;
import domain.User;
import domain.Wallet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Exchange", urlPatterns = "/user/wallet/exchange")
public class Exchange extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int fromId = Integer.parseInt(request.getParameter("firstId"));
        int toId = Integer.parseInt(request.getParameter("secondId"));
        int sum = Integer.parseInt(request.getParameter("sum"));
        History history = new History();
        User user = (User) request.getSession().getAttribute("user");
        boolean complete = false;

        MySqlWalletDao walletDao = new MySqlWalletDao();
        MySqlHistoryDao historyDao = new MySqlHistoryDao();

        for (Wallet walletFrom : walletDao.readForUserById(user.getId())) {
            if ((walletFrom.getId() == fromId) && (walletFrom.getSum() - sum >= 0)) {
                for (Wallet walletTo : walletDao.getAll()) {
                    if (walletTo.getId() == toId) {
                        walletDao.exchangeById(fromId, toId, sum);

                        int userIdTo = walletDao.readWalletById(toId).getUserId();

                        history.setUserIdFrom(user.getId());
                        history.setUserIdTo(userIdTo);
                        history.setWalletIdFrom(fromId);
                        history.setWalletIdTo(toId);
                        history.setSum(sum);
                        historyDao.create(history);

                        complete = true;
                        response.sendRedirect("/user");
                    }
                }
            }
        }

        if (!complete) {
            request.setAttribute("error", "<font color = red>Wrong data</font>");
            getServletContext().getRequestDispatcher("/views/wallets/exchange.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/views/wallets/exchange.jsp").forward(request, response);
    }
}
