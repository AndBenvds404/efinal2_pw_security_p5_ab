package com.example.api_server_autorizacion.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {

    
    
    @Value("${app.jwtSemilla}")
    private String jwtSemilla;

    @Value("${app.jwtExpirationMs}")
    private int jwtExpirationMS;
    
    public String builTokenJwt(String nombre, String semilla, int tiempo){

    System.out.println("semilla--"+jwtSemilla);
    System.out.println("tiempo--"+jwtExpirationMS);
 
		return Jwts.builder().setSubject(nombre).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + tiempo))
				.signWith(SignatureAlgorithm.HS512, semilla).compact();
    }
}
