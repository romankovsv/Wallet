package servlets.currency;

import database.currency.MySqlCurrencyDao;
import org.apache.log4j.Logger;
import database.currency.Currency;

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
@WebServlet(name = "CurrencyList", urlPatterns = "/currency-list")
public class CurrencyList extends HttpServlet {
    private static final Logger log = Logger.getLogger(CurrencyList.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Currency> list;

        MySqlCurrencyDao currencyDao = new MySqlCurrencyDao();
        list = currencyDao.getAll();

        request.setAttribute("list", list);
        getServletContext().getRequestDispatcher("/views/currency/currency.jsp").forward(request, response);
    }
}
