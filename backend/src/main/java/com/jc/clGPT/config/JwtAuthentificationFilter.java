package com.jc.clGPT.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static com.jc.clGPT.config.SecurityConstants.HEADER_STRING;
import static com.jc.clGPT.config.SecurityConstants.TOKEN_PREFIX;

@Component
@RequiredArgsConstructor
public class JwtAuthentificationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    )throws ServletException, IOException {
        final String authHeader = request.getHeader(HEADER_STRING);
        final String jwt;
        final String userEmail;
        if (authHeader == null || !authHeader.startsWith(TOKEN_PREFIX)){
            filterChain.doFilter(request, response);
            return;
        }
        jwt = authHeader.substring(7);
        userEmail = jwtService.extractUsername(jwt);
    }
}
