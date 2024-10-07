package com.events.riwi.utils.helpers;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders; // Importamos las cabeceras HTTP
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTFilter extends OncePerRequestFilter {
    @Autowired
    private JWTService jwtService;

    @Autowired
    UserDetailsService userDetailsService;

    public String getTokenFromRequest(HttpServletRequest request) {

        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (StringUtils.hasLength(authHeader) && authHeader.startsWith("Bearer ")) { // Verificamos si el encabezado tiene longitud y comienza con "Bearer "
            return authHeader.substring(7); // Retornamos el token, eliminando el prefijo "Bearer "
        }
        return null; // Retornamos null si no hay token
    }


    @Override // Sobrescribimos el método doFilterInternal
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String token = getTokenFromRequest(request); // Obtenemos el token de la solicitud
        if (token == null) { // Si no hay token
            filterChain.doFilter(request, response); // Continuamos con el filtro
            return; // Salimos del método
        }

        // Obtenemos el nombre de usuario del token
        String username = jwtService.getUsernameFromToken(token);
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) { // Si el nombre de usuario no es null y no hay autenticación en el contexto
            UserDetails userDetails = userDetailsService.loadUserByUsername(username); // Cargamos los detalles del usuario
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken( // Creamos un token de autenticación
                    userDetails,
                    null,
                    userDetails.getAuthorities() // Establecemos las autoridades del usuario
            );
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); // Establecemos los detalles de autenticación
            SecurityContextHolder.getContext().setAuthentication(authenticationToken); // Establecemos la autenticación en el contexto de seguridad
        }

        filterChain.doFilter(request, response); // Continuamos con la cadena de filtros
    }
}
