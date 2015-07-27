package servlets.currency;

import database.currency.MySqlCurrencyDao;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Created by SpiritMoon
 */
@WebServlet(name = "DeleteCurrency", urlPatterns = "/deleteById-currency")
public class DeleteCurrency extends HttpServlet {
    private static final Logger log = Logger.getLogger(DeleteCurrency.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MySqlCurrencyDao currencyDao = new MySqlCurrencyDao();
        int id = Integer.parseInt(request.getParameter("id"));
        currencyDao.deleteById(id);
        getServletContext().getRequestDispatcher("/views/currency/currency-list").forward(request, response);
    }
}
