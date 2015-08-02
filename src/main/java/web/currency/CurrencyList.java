package web.currency;

import dao.currency.MySqlCurrencyDao;
import domain.Currency;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CurrencyList", urlPatterns = "/currency-list")
public class CurrencyList extends HttpServlet {
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
