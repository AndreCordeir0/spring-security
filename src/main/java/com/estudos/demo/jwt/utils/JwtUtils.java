package com.estudos.demo.jwt.utils;

import com.estudos.demo.securingweb.UserDetailImpl;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import java.security.Key;
import java.security.SignatureException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${teste.app.jwtSecret}")
    private String jwtSecret;

    @Value("${teste.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    @Value("${teste.app.jwtCookieName}")
    private String jwtCookie;



    //RECUPERA USUARIO POR TOKEN
    public String getUsuarioWithToken(String token) {
        return Jwts.parserBuilder().setSigningKey(jwtSecret).build().parseClaimsJws(token).getBody().getSubject();
    }

    public Boolean validarToken(String token, UserDetails userDetails) {
        final String username = obterUsuario(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public String generateToken(String username){
        Map<String, Object> claim = new HashMap<String, Object>();
        return generateTokenFromUsername(claim,username);
    }
    private Boolean isTokenExpired(String token) {
        final Date dataValidade = obterDataValidade(token);
        return dataValidade.before(new Date());
    }
    public Date obterDataValidade(String token) {
        return obterClaim(token, Claims::getExpiration);
    }
    private <T> T obterClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = obterClaims(token);
        return claimsResolver.apply(claims);

    }
    public String obterUsuario(String token) {
        return obterClaim(token, Claims::getSubject);
    }
    private Claims obterClaims(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
    }


    //GERA UM NOVO TOKEN
    public String generateTokenFromUsername(Map<String, Object> claim , String username) {
        return Jwts.builder()
                .setClaims(claim)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public static void main(String[] args) {
        String token = Teste.generateTokenFromUsername(new HashMap<>(),"AAA");
        System.out.println(token);
        String t= Teste.getUsuarioWithToken("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBQUEiLCJpYXQiOjE2NzY5NDQ4NjMsImV4cCI6MTY3NzAyOTMwN30.v5xk0AB18kxQBGhaUDw0kWYAPGONwP-7Rdbo6-OD9Ap9o-Jd4Gi7Ug_3P05Hguh8ohiy2sHRHLWtnL0Zk56pkg");
        System.out.println(t);
    }
}
class Teste{

    public static String generateTokenFromUsername(Map<String, Object> claim , String username) {
        byte[] bytes = Decoders.BASE64.decode("testesssssssssssssssssssssssssssssssssssssssssssssssssffffffffffffffffffffffffffffffasfdasgadsgdsvewgewgews");
        Key secretKey = Keys.hmacShaKeyFor(bytes);
        return Jwts.builder()
                .setClaims(claim)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + 84444444))
                .signWith(SignatureAlgorithm.HS512,secretKey)
                .compact();
    }

    public static String getUsuarioWithToken(String token) {
        byte[] bytes = Decoders.BASE64.decode("testesssssssssssssssssssssssssssssssssssssssssssssssssffffffffffffffffffffffffffffffasfdasgadsgdsvewgewgews");
        Key secretKey = Keys.hmacShaKeyFor(bytes);

        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody().getSubject();
    }
}