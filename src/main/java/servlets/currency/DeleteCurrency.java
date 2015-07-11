package servlets.currency;

import org.apache.log4j.Logger;
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
/**
 * Created by SpiritMoon
 */
@WebServlet(name = "DeleteCurrency", urlPatterns = "/delete-currency")
public class DeleteCurrency extends HttpServlet {
    private static final Logger log = Logger.getLogger(DeleteCurrency.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoFactory daoFactory = new MySqlDaoFactory();

        try (Connection connection = daoFactory.getConnection()) {
            CurrencyDao currencyDao = daoFactory.getCurrencyDao(connection);
            int id = Integer.parseInt(request.getParameter("id"));
            currencyDao.delete(id);
            getServletContext().getRequestDispatcher("/views/currency/currency-list").forward(request, response);
        } catch (SQLException e) {
            log.error("Error in operation", e);
        }
    }
}
