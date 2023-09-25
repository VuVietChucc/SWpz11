package vn.fpt.edu.cinema.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.fpt.edu.cinema.dto.request.account.*;
import vn.fpt.edu.cinema.dto.request.common.GeneralResponse;
import vn.fpt.edu.cinema.dto.response.AccountResponse;
import vn.fpt.edu.cinema.dto.response.CreateAccountResponse;
import vn.fpt.edu.cinema.dto.response.LoginResponse;

/**
 * vn.fpt.edu.cinema.controller
 *
 * @author : Portgas.D.Ace
 * @created : 21/05/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/
@RequestMapping("/public/api/v1/accounts")
public interface AccountController {

    @PostMapping
    ResponseEntity<GeneralResponse<CreateAccountResponse>> createAccount(@RequestBody CreateAccountRequest request);

    @PostMapping("/account/login")
    ResponseEntity<GeneralResponse<LoginResponse>> login(@RequestBody LoginRequest request);

    @PostMapping("/account/login/gg")
    ResponseEntity<GeneralResponse<LoginResponse>> loginWithGoogle(@RequestBody LoginGgRequest email);

    @PostMapping("/password/reset")
    ResponseEntity<GeneralResponse<Object>> resetPassword(@RequestBody ResetPasswordRequest request);

    @PutMapping("/{id}/password")
    ResponseEntity<GeneralResponse<Object>> changePassword(
            @PathVariable("id") String id,
            @RequestBody ChangePasswordRequest request);

    @PutMapping("/{id}/email")
    ResponseEntity<GeneralResponse<Object>> changeEmail(
            @PathVariable String id,
            @RequestBody ChangeEmailRequest request);

    @PutMapping("/{account-id}")
    ResponseEntity<GeneralResponse<Object>> updateProfiles(@PathVariable("account-id") String accountId, @RequestBody UpdateProfileRequest request);

    @GetMapping("/{account-id}")
    ResponseEntity<GeneralResponse<AccountResponse>> getAccountDetail(@PathVariable(name = "account-id") String accountId);
}
