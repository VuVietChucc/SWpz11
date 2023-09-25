package vn.fpt.edu.cinema.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.fpt.edu.cinema.dto.request.account.*;
import vn.fpt.edu.cinema.dto.response.AccountResponse;
import vn.fpt.edu.cinema.dto.response.CreateAccountResponse;
import vn.fpt.edu.cinema.dto.response.LoginResponse;

/**
 * vn.fpt.edu.cinema.service
 *
 * @author : Portgas.D.Ace
 * @created : 21/05/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/

public interface AccountService {

    void init();
    CreateAccountResponse createAccount(CreateAccountRequest request);

    LoginResponse login(LoginRequest request);

    LoginResponse loginWithGoogle(String email);

    void changeEmail(String id, ChangeEmailRequest request);

    void changePassword(String id, ChangePasswordRequest request);

    void resetPassword(ResetPasswordRequest request);

    AccountResponse getAccountDetail(String accountId);

    void updateProfile(String accountId, UpdateProfileRequest request);

    Page<AccountResponse> getAllAccount(Pageable pageable, String search);
}
