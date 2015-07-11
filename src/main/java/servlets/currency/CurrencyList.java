package servlets.currency;

import org.apache.log4j.Logger;
import database.currency.Currency;
import database.currency.CurrencyDao;
import database.factory.DaoFactory;
import database.factory.MySqlDaoFactory;

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
@WebServlet(name = "CurrencyList", urlPatterns = "/currency-list")
public class CurrencyList extends HttpServlet {
    private static final Logger log = Logger.getLogger(CurrencyList.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoFactory daoFactory =  new MySqlDaoFactory();
        List<Currency> list = new ArrayList<>();

        try(Connection connection = daoFactory.getConnection()) {
            CurrencyDao currencyDao = daoFactory.getCurrencyDao(connection);
            list = currencyDao.getAll();
        } catch (SQLException e) {
            log.error("Error in operation", e);
        }

        request.setAttribute("list", list);
        getServletContext().getRequestDispatcher("/views/currency/currency.jsp").forward(request, response);
    }
}
