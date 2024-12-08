package filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import entity.User;

@WebFilter("/*")
public class AuthorizationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization if needed
    }

    @Override
    public void doFilter(jakarta.servlet.ServletRequest request, jakarta.servlet.ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        
        HttpSession session = httpRequest.getSession(false);
        User user = (session != null) ? (User) session.getAttribute("User") : null;

      
        String uri = httpRequest.getRequestURI();

       
        if (user == null) {
           
            if (uri.contains("/adminPage")) {
                httpResponse.sendRedirect("error.jsp");
                return;
            }
        } else {
            String role = user.getRole();

           
            if ("customer".equals(role) && uri.contains("/adminPage.jsp")) {
                httpResponse.sendRedirect("error.jsp");
                return;
            }


        }

      
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Cleanup if needed
    }
}
