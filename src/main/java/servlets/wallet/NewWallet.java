package servlets.wallet;

import database.currency.MySqlCurrencyDao;
import database.system.MySqlSystemTypeDao;
import database.system_currency.MySqlSystemCurrencyDao;
import database.currency.Currency;
import database.system.SystemType;
import database.system_currency.SystemCurrency;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddWallet", urlPatterns = "/user/new-wallet")
public class NewWallet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Currency> currencyList;
        List<SystemType> systemTypeList;
        List<SystemCurrency> systemCurrencies;

        MySqlCurrencyDao currencyDao = new MySqlCurrencyDao();
        MySqlSystemTypeDao systemTypeDao = new MySqlSystemTypeDao();
        MySqlSystemCurrencyDao systemCurrenciesDao = new MySqlSystemCurrencyDao();

        currencyList = currencyDao.getAll();
        systemTypeList = systemTypeDao.getAll();
        systemCurrencies = systemCurrenciesDao.getAll();

        request.setAttribute("type", systemTypeList);
        request.setAttribute("currency", currencyList);
        request.setAttribute("sc", systemCurrencies);
        getServletContext().getRequestDispatcher("/views/wallets/newWallet.jsp").forward(request, response);
    }
}
