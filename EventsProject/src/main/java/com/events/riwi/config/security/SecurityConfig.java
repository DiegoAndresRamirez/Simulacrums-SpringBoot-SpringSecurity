package com.events.riwi.config.security;

import com.events.riwi.utils.helpers.JWTFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Autowired
    AuthenticationProvider authenticationProvider;

    @Autowired
    JWTFilter jwtFilter;

    String[] PUBLIC_URLS = {"/login", "/register", "/swagger-ui/**", "v3/api-docs/**", "/v3/api-docs.yaml",
            "/swagger-ui.html"};

    @Bean // Declaramos un bean para la cadena de filtros de seguridad
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable()) // Deshabilitamos la protección CSRF
                .authorizeHttpRequests(auth -> auth // Configuramos la autorización de las peticiones HTTP
                        .requestMatchers(PUBLIC_URLS).permitAll() // Permitimos el acceso sin autenticación a estas rutas
                        .requestMatchers("/create-project").hasAnyAuthority("ADMIN") // Solo los usuarios con autoridad ADMIN pueden acceder a esta ruta
                        .anyRequest().authenticated()) // Cualquier otra solicitud necesita autenticación
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Configuramos la política de sesión como sin estado
                .authenticationProvider(authenticationProvider) // Establecemos el proveedor de autenticación
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class) // Añadimos el filtro JWT antes del filtro de autenticación
                .httpBasic(Customizer.withDefaults()); // Habilitamos la autenticación básica con valores por defecto

        return http.build(); // Construimos y retornamos la cadena de filtros de seguridad
    }


}
