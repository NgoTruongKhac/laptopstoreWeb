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

        // Get the session and check for the logged-in user
        HttpSession session = httpRequest.getSession(false);
        User user = (session != null) ? (User) session.getAttribute("User") : null;

        // Get requested URI
        String uri = httpRequest.getRequestURI();

        // Authorization logic
        if (user == null) {
            // If the user is not logged in and tries to access admin page, redirect to login or index
            if (uri.contains("/adminPage")) {
                httpResponse.sendRedirect("error.jsp");
                return;
            }
        } else {
            String role = user.getRole();

            // Redirect customers trying to access admin page
            if ("customer".equals(role) && uri.contains("/adminPage.jsp")) {
                httpResponse.sendRedirect("error.jsp");
                return;
            }


        }

        // Allow request to proceed if no restrictions are hit
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Cleanup if needed
    }
}
