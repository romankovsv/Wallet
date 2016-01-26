package web.currency;

import dao.impl.MySqlCurrencyDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteCurrency", urlPatterns = "/deleteById-currency")
public class DeleteCurrency extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MySqlCurrencyDao currencyDao = new MySqlCurrencyDao();
        int id = Integer.parseInt(request.getParameter("id"));
        currencyDao.deleteById(id);
        getServletContext().getRequestDispatcher("/views/currency-list").forward(request, response);
    }
}
