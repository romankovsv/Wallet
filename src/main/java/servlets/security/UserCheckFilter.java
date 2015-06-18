package servlets.security;

import tables.users.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Created by SpiritMoon
 */
@WebFilter("/AuthenticationFilter")
public class UserCheckFilter implements javax.servlet.Filter {
    private String LOGIN_ACTION_URI;

    public void init(FilterConfig config) throws ServletException {
        LOGIN_ACTION_URI = config.getInitParameter("loginActionURI");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        String name = (String) session.getAttribute("name");

        if (name == null && !LOGIN_ACTION_URI.equals(req.getRequestURI())) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
            requestDispatcher.forward(request, response);
        }

        chain.doFilter(request, response);

//        if (((HttpServletRequest)request).getSession().getAttribute("id") != null) {
//            chain.doFilter(request, response);
//        } else {
//            ((HttpServletResponse)response).sendRedirect("login.jsp");
//        }
    }

    public void destroy() {

    }
}
