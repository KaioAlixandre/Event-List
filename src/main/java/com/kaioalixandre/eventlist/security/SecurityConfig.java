// SecurityConfig.java
package com.kaioalixandre.eventlist.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.kaioalixandre.eventlist.filter.JwtAuthFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;

    public SecurityConfig(JwtAuthFilter jwtAuthFilter) {
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/events/create").authenticated() // Apenas para criar eventos
                .requestMatchers("/events/me").authenticated() // Permite acesso a lista de eventos autenticados
                .requestMatchers("/events/{id}").authenticated() // Apenas para editar e excluir eventos
                .requestMatchers("/users/**").permitAll() // Rotas de autenticação (login, cadastro)
                .requestMatchers("/", "/index.html", "/login.html", "/cadastro.html", "/eventos.html", "lista-eventos.html").permitAll() // Páginas HTML
                .requestMatchers("/*.css", "/*.js").permitAll() // CSS e JS
                .anyRequest().authenticated() // Todas as outras rotas exigem autenticação
            )
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}