package lms.demo.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lms.demo.model.jwtModel.JwtUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

@Component
public class RequestLoggingFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil = new JwtUtil();

//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//            throws ServletException, IOException {
//        String authorizationHeader = request.getHeader("Authorization");
//
//        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//            String token = authorizationHeader.substring(7);
//            if (!jwtUtil.validateToken(token)) {
////                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//                response.getWriter().write("Invalid or expired token");  // Optional: Send an error message
//                return;
//            }
//        }
//        chain.doFilter(request, response);
//    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        try {
            String authorizationHeader = request.getHeader("Authorization");
            System.out.println("Authorization header: " + authorizationHeader);

            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                String token = authorizationHeader.substring(7);
                System.out.println("Extracted token: " + token.substring(0, Math.min(10, token.length())) + "...");

                if (!jwtUtil.validateToken(token)) {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.getWriter().write("Invalid or expired token");
                    return;
                }
            }
            chain.doFilter(request, response);
        } catch (Exception e) {
            System.out.println("Error in filter: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }


}







