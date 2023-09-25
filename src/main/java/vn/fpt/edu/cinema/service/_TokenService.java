package vn.fpt.edu.cinema.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import vn.fpt.edu.cinema.dto.request.account.LoginRequest;
import vn.fpt.edu.cinema.entity.Account;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * vn.fpt.edu.cinema.service
 *
 * @author : Portgas.D.Ace
 * @created : 29/05/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/


public interface _TokenService {

    Optional<Authentication> getAuthenticationFromToken(String token);

    String generateToken(Account account, UserDetails userDetails);

    LocalDateTime getExpiredTimeFromToken(String token);

    String generateRefreshToken(LoginRequest request);

}
