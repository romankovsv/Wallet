package servlets.wallet;

import tables.currency.Currency;
import tables.factory.DaoFactory;
import tables.factory.MySqlDaoFactory;
import tables.system.SystemType;
import tables.system_currency.SystemCurrency;

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
@WebServlet(name = "AddWallet", urlPatterns = "/user/new-wallet")
public class NewWallet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoFactory daoFactory = new MySqlDaoFactory();
        List<Currency> currencyList = new ArrayList<>();
        List<SystemType> systemTypeList = new ArrayList<>();
        List<SystemCurrency> systemCurrencies = new ArrayList<>();

        try(Connection connection = daoFactory.getConnection()) {
            currencyList = daoFactory.getCurrencyDao(connection).getAll();
            systemTypeList = daoFactory.getSystemTypeDao(connection).getAll();
            systemCurrencies = daoFactory.getSCDao(connection).getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("type", systemTypeList);
        request.setAttribute("currency", currencyList);
        request.setAttribute("sc", systemCurrencies);
        getServletContext().getRequestDispatcher("/newWallet.jsp").forward(request, response);
    }
}
