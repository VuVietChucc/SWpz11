package vn.fpt.edu.cinema.service.impl;

import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import vn.fpt.edu.cinema.constant.ResponseStatusEnum;
import vn.fpt.edu.cinema.dto.request.account.LoginRequest;
import vn.fpt.edu.cinema.entity.Account;
import vn.fpt.edu.cinema.exception.BusinessException;
import vn.fpt.edu.cinema.service._TokenService;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

import static vn.fpt.edu.cinema.utils.AuditorUtils.*;

/**
 * vn.fpt.edu.cinema.service.impl
 *
 * @author : Portgas.D.Ace
 * @created : 29/05/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/
@Service
@Slf4j
@RequiredArgsConstructor
public class TokenServiceImpl implements _TokenService {

    private static String SECRET_KEY;
    @Value("${app.security.secret-key}")
    private void setSecretKey(String secretKey){
        SECRET_KEY = secretKey;
    }
    @Value("${app.security.expiration}")
    private int TOKEN_EXPIRATION;
    @Value("${app.security.refresh-token.expiration}")
    private int REFRESH_TOKEN_EXPIRATION;
    @Value("${app.application-context}")
    private String APPLICATION_CONTEXT;

    @Override
    public Optional<Authentication> getAuthenticationFromToken(String token) {
        Jws<Claims> jwsClaims = validateToken(token);
        if (jwsClaims == null) {
            return Optional.empty();
        }

        if(!validateTokenHeader(jwsClaims.getHeader())){
            return Optional.empty();
        }

        Claims claims = jwsClaims.getBody();

        if(!validateExpiredTime(claims)){
            return Optional.empty();
        }

        String id = claims.getId();

        String authorities = claims.get("authorities", String.class);

        Collection<? extends GrantedAuthority> grantedAuthorities = convertToAuthority(authorities);

        User principal = new User(id, "", grantedAuthorities);
        return Optional.of(new UsernamePasswordAuthenticationToken(principal, token, grantedAuthorities));

    }

    @Override
    public String generateToken(Account account, UserDetails userDetails) {

        Map<String, Object> claims = new HashMap<>();
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        Long currentTime = calendar.getTimeInMillis();
        calendar.add(Calendar.SECOND, TOKEN_EXPIRATION);
        Long expirationTime = calendar.getTimeInMillis();
        String authorities = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(","));
        claims.put(Claims.ID, account.getAccountId());
        claims.put(Claims.SUBJECT, account.getUsername());
        claims.put("email", account.getEmail());
        claims.put("fullName", account.getFullName());
        claims.put("authorities", authorities);
        claims.put(Claims.ISSUER, APPLICATION_CONTEXT);
        claims.put(Claims.EXPIRATION, expirationTime);
        claims.put(Claims.ISSUED_AT, currentTime);

        Map<String, Object> headers = new HashMap<>();
        headers.put("alg", "HS256");
        headers.put(Header.TYPE, Header.JWT_TYPE);

        return Jwts.builder()
                .setHeader(headers)
                .addClaims(claims)
                .signWith(getSigningKey())
                .compact();
    }

    @Override
    public LocalDateTime getExpiredTimeFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        long expiredTime = claims.get(Claims.EXPIRATION, Long.class);
        return Instant.ofEpochMilli(expiredTime).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    @Override
    public String generateRefreshToken(LoginRequest request) {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.add(Calendar.SECOND, REFRESH_TOKEN_EXPIRATION);
        Map<String, Object> claims = new HashMap<>();
        claims.put("emailOrUsername", request.getEmailOrUsername());
        claims.put("password", request.getPassword());
        claims.put(Claims.EXPIRATION, calendar.getTimeInMillis());

        Map<String, Object> headers = new HashMap<>();
        headers.put("alg", "HS256");
        headers.put(Header.TYPE, Header.JWT_TYPE);

        return Jwts.builder()
                .setHeader(headers)
                .setClaims(claims)
                .signWith(getSigningKey())
                .compact();
    }

    private boolean validateTokenHeader(JwsHeader jwsHeader){
        String alg = jwsHeader.getAlgorithm();
        String headerType = jwsHeader.getType();
        return alg.equals("HS256") && headerType.equals(Header.JWT_TYPE);
    }

    private boolean validateExpiredTime(Claims claims){
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        Long currentTime = calendar.getTimeInMillis();

        Long expirationTime = claims.get(Claims.EXPIRATION, Long.class);
        return expirationTime > currentTime;
    }


    private Collection<? extends GrantedAuthority> convertToAuthority(String authority){
        String[] authorities = authority.split(",");
        return Arrays.stream(authorities)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    private Jws<Claims> validateToken(String token) {
        try {
            return getJwtParser().parseClaimsJws(token);
        }catch (Exception ex){
            return null;
        }
    }
}
