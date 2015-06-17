package servlets.security;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
    /**
 * Created by SpiritMoon
 */
@WebFilter("/AuthenticationFilter")
public class Filter implements javax.servlet.Filter {
    private ServletContext context;

    public void destroy() {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        this.context.log("Requested Resource::"+uri);

        HttpSession session = req.getSession(false);

        if(session == null && !(uri.endsWith("jsp") || uri.endsWith("login"))){
            this.context.log("Unauthorized access request");
            res.sendRedirect("login.jsp");
        }else{
            chain.doFilter(request, response);
        }

//        if (((HttpServletRequest)request).getSession().getAttribute("id") != null) {
//            chain.doFilter(request, response);
//        } else {
//            ((HttpServletResponse)response).sendRedirect("login.jsp");
//        }
    }

    public void init(FilterConfig config) throws ServletException {
        this.context = config.getServletContext();
        this.context.log("AuthenticationFilter initialized");
    }

}
