package servlets.currency;

import tables.currency.Currency;
import tables.currency.CurrencyDao;
import tables.factory.DaoFactory;
import tables.factory.MySqlDaoFactory;

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
@WebServlet(name = "CurrencyList", urlPatterns = "/currency")
public class CurrencyList extends HttpServlet {
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
            e.printStackTrace();
        }

        request.setAttribute("list", list);
        getServletContext().getRequestDispatcher("/сurrency.jsp").forward(request, response);
    }
}
