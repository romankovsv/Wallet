package servlets.login;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
/**
 * Created by SpiritMoon
 */
@WebFilter(filterName = "Filter", urlPatterns = "/user/*")
public class Filter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        if (((HttpServletRequest)request).getSession().getAttribute("id") != null) {
            chain.doFilter(request, response);
        } else {
            request.getServletContext().getRequestDispatcher("/401.jsp").forward(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
