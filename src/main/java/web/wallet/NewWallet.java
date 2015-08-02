package web.wallet;

import dao.currency.MySqlCurrencyDao;
import dao.type.MySqlTypeDao;
import dao.type_currency.MySqlTypeCurrencyDao;
import domain.Currency;
import domain.Type;
import domain.TypeCurrency;

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
        List<Type> typeList;
        List<TypeCurrency> systemCurrencies;

        MySqlCurrencyDao currencyDao = new MySqlCurrencyDao();
        MySqlTypeDao systemTypeDao = new MySqlTypeDao();
        MySqlTypeCurrencyDao systemCurrenciesDao = new MySqlTypeCurrencyDao();

        currencyList = currencyDao.getAll();
        typeList = systemTypeDao.getAll();
        systemCurrencies = systemCurrenciesDao.getAll();

        request.setAttribute("type", typeList);
        request.setAttribute("currency", currencyList);
        request.setAttribute("sc", systemCurrencies);
        getServletContext().getRequestDispatcher("/views/wallets/newWallet.jsp").forward(request, response);
    }
}
