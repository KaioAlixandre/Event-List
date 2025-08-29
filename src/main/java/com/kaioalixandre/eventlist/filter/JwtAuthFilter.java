// JwtAuthFilter.java
package com.kaioalixandre.eventlist.filter;

import java.io.IOException;
import java.util.Collections;
import java.util.UUID;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.kaioalixandre.eventlist.utils.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);

            // Usa o método correto para obter o ID do usuário
            UUID userId = JwtUtil.validateTokenAndGetUserId(token);

            if (userId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                // Adiciona a autoridade "ROLE_USER"
                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(userId.toString(), null, Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
                
                auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(auth);
                
                // Coloca o id do usuário na requisição para que o controller possa usá-lo
                request.setAttribute("idUser", userId);
            }
        }
        filterChain.doFilter(request, response);
    }
}