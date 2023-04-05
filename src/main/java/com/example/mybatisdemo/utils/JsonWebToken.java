package com.example.mybatisdemo.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JsonWebToken {
  private static String secret = "coder_sdalsda";
  private static int expire = 604800;


  public static String generateToken(String username) {
    Date now = new Date();
    Date expiration = new Date(now.getTime() + 1000 * expire);
    return Jwts.builder()
      .setHeaderParam("type", "JWT")
      .setSubject(username)
      .setIssuedAt(now)
      .setExpiration(expiration)
      .signWith(SignatureAlgorithm.HS512, secret)
      .compact();
  }

  public static Claims getClaimsByToken(String token) {
    return Jwts.parser()
      .setSigningKey(secret)
      .parseClaimsJws(token)
      .getBody();
  }
}
