package lms.demo.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.logging.Logger;

@Component
public class RequestLoggingFilter extends OncePerRequestFilter {

    private static final Logger logger = Logger.getLogger(RequestLoggingFilter.class.getName());

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        logger.info("Intercepted request: " + request.getMethod() + " " + request.getRequestURI());

        String token = request.getHeader("access_token");

        if (!token.equals("abc")) {
            throw new ServletException("au");
        }

        // Proceed with the filter chain
        filterChain.doFilter(request, response);
        
        // Log after processing the response
        logger.info("Response status: " + response.getStatus());
    }
}
