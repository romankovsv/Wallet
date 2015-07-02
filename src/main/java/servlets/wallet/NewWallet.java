package servlets.wallet;

import org.apache.log4j.Logger;
import database.currency.Currency;
import database.factory.DaoFactory;
import database.factory.MySqlDaoFactory;
import database.system.SystemType;
import database.system_currency.SystemCurrency;

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
    private static final Logger log = Logger.getLogger(NewWallet.class);

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
            log.error(e);
        }

        request.setAttribute("type", systemTypeList);
        request.setAttribute("currency", currencyList);
        request.setAttribute("sc", systemCurrencies);
        getServletContext().getRequestDispatcher("/newWallet.jsp").forward(request, response);
    }
}
