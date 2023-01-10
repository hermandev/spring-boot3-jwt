package id.codecorn.springjwt.service;

import java.util.function.Function;

import io.jsonwebtoken.Claims;

public interface JwtService {

    String extractUsername(String jwt);

    <T> T extractClaim(String token, Function<Claims, T> claimsResolver);

}
