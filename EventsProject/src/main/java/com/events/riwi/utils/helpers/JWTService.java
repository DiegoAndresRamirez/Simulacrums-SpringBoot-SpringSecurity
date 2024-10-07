package com.events.riwi.utils.helpers;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTService {

    @Value("${jwt.secret}") // Leemos el secreto del token desde las propiedades
    private String secret; // Secreto para firmar los tokens

    @Value("${jwt.expiration}") // Leemos la expiración del token desde las propiedades
    private long expiration; // Tiempo de expiración del token en milisegundos

    // Método para obtener el nombre de usuario del token
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject); // Obtenemos el nombre de usuario (subject) del token
    }

    // Método para obtener una reclamación específica del token
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token); // Obtenemos todas las reclamaciones del token
        return claimsResolver.apply(claims); // Aplicamos el resolver de reclamaciones
    }

    // Método para obtener todas las reclamaciones del token
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody(); // Parseamos el token y obtenemos el cuerpo de las reclamaciones
    }

    // Método para verificar si el token ha expirado
    private Boolean isTokenExpired(String token) {
        final Date expirationDate = getClaimFromToken(token, Claims::getExpiration); // Obtenemos la fecha de expiración del token
        return expirationDate.before(new Date()); // Comprobamos si la fecha de expiración es anterior a la fecha actual
    }

    // Método para generar un nuevo token
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>(); // Creamos un mapa para las reclamaciones
        return createToken(claims, userDetails.getUsername()); // Creamos el token usando el mapa de reclamaciones y el nombre de usuario
    }

    // Método para crear el token
    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder() // Creamos un nuevo builder para el JWT
                .setClaims(claims) // Establecemos las reclamaciones
                .setSubject(subject) // Establecemos el subject (nombre de usuario)
                .setIssuedAt(new Date(System.currentTimeMillis())) // Establecemos la fecha de emisión
                .setExpiration(new Date(System.currentTimeMillis() + expiration)) // Establecemos la fecha de expiración
                .signWith(SignatureAlgorithm.HS256, secret) // Firmamos el token con el algoritmo HS256 y el secreto
                .compact(); // Compactamos y retornamos el token
    }

    // Método para validar el token
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token); // Obtenemos el nombre de usuario del token
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token)); // Validamos el token comparando el nombre de usuario y verificando que no esté expirado
    }

}
