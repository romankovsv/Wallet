package servlets.wallet;

import tables.currency.Currency;
import tables.currency.CurrencyDao;
import tables.factory.DaoFactory;
import tables.factory.MySqlDaoFactory;
import tables.system.SystemType;
import tables.system.SystemTypeDao;
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
@WebServlet(name = "AddWallet", urlPatterns = "/user/addwallet")
public class AddWallet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoFactory daoFactory = new MySqlDaoFactory();
        int id = (int) request.getSession().getAttribute("id");
        List<SystemType> systemTypeList = new ArrayList<>();
        List<Currency> currencyList = new ArrayList<>();

        try(Connection connection = daoFactory.getConnection()) {
            WalletDao walletDao = daoFactory.getWalletDao(connection);
            CurrencyDao currencyDao = daoFactory.getCurrencyDao(connection);
            SystemTypeDao systemType = daoFactory.getSystemTypeDao(connection);

            systemTypeList = systemType.getAll();
            currencyList = currencyDao.getAll();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/user").forward(request, response);
    }
}
