package com.example.HotelServer.configs;


import com.example.HotelServer.entity.User;
import com.example.HotelServer.services.jwt.UserService;
import com.example.HotelServer.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    private final UserService userService;

    // Constructor for dependency injection
    public JwtAuthenticationFilter(JwtUtil jwtUtil, UserService userService) {
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Extract the Authorization header
        final String authHeader = request.getHeader("Authorization");
        if(StringUtils.isEmpty(authHeader) || !StringUtils.startsWith(authHeader, "Bearer")){
            filterChain.doFilter(request, response);
            return;
        }

        // Extract the JWT token from the Authorization header
        final String jwt;
        jwt = authHeader.substring(7);
        final String userEmail;

        // Extract the username (email) from the JWT
        userEmail = jwtUtil.extractUserName(jwt);

        // If the username is valid and no authentication exists, validate the token
        if(StringUtils.isNotEmpty(userEmail) &&
                SecurityContextHolder.getContext().getAuthentication() == null){
            // Load user details from the UserService
            UserDetails userDetails = userService.userDetailsService().loadUserByUsername(userEmail);

            // If the token is valid, set the security context
            if(jwtUtil.isTokenValid(jwt, userDetails)){
                SecurityContext context = SecurityContextHolder.createEmptyContext();

                // Create an authentication token with user details and authorities
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities()
                );
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                context.setAuthentication(authToken);

                SecurityContextHolder.setContext(context);
            }
        }

        // Continue the filter chain
        filterChain.doFilter(request, response);
    }
}
