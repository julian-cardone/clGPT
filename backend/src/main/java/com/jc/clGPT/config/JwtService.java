package com.jc.clGPT.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    private static final String


    public String extractUsername(String token) {
        return null;
    }

    private Claims extractAllClaimsS(String token){
        return Jwts.parserBuilder().setSigningKey(getSignInKey()).build().parsePlaintextJws(token).getBody();

    }
}
