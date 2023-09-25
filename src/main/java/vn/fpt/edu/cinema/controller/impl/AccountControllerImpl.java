package vn.fpt.edu.cinema.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import vn.fpt.edu.cinema.constant.ResponseStatusEnum;
import vn.fpt.edu.cinema.controller.AccountController;
import vn.fpt.edu.cinema.dto.request.account.*;
import vn.fpt.edu.cinema.dto.request.common.GeneralResponse;
import vn.fpt.edu.cinema.dto.response.AccountResponse;
import vn.fpt.edu.cinema.dto.response.CreateAccountResponse;
import vn.fpt.edu.cinema.dto.response.LoginResponse;
import vn.fpt.edu.cinema.factory.ResponseFactory;
import vn.fpt.edu.cinema.service.AccountService;

/**
 * vn.fpt.edu.cinema.controller.impl
 *
 * @author : Portgas.D.Ace
 * @created : 21/05/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/
@RestController
@RequiredArgsConstructor
public class AccountControllerImpl implements AccountController {

    private final ResponseFactory responseFactory;
    private final AccountService accountService;

    @Override
    public ResponseEntity<GeneralResponse<CreateAccountResponse>> createAccount(CreateAccountRequest request) {
        return responseFactory.response(accountService.createAccount(request), ResponseStatusEnum.CREATED);
    }

    @Override
    public ResponseEntity<GeneralResponse<LoginResponse>> login(LoginRequest request) {
        return responseFactory.response(accountService.login(request));
    }

    @Override
    public ResponseEntity<GeneralResponse<LoginResponse>> loginWithGoogle(LoginGgRequest email) {
        return responseFactory.response(accountService.loginWithGoogle(email.getEmail()));
    }

    @Override
    public ResponseEntity<GeneralResponse<Object>> resetPassword(ResetPasswordRequest request) {
        accountService.resetPassword(request);
        return responseFactory.response(ResponseStatusEnum.SUCCESS);
    }

    @Override
    public ResponseEntity<GeneralResponse<Object>> changePassword(String id, ChangePasswordRequest request) {
        accountService.changePassword(id, request);
        return responseFactory.response(ResponseStatusEnum.SUCCESS);
    }

    @Override
    public ResponseEntity<GeneralResponse<Object>> changeEmail(String id, ChangeEmailRequest request) {
        accountService.changeEmail(id, request);
        return responseFactory.response(ResponseStatusEnum.SUCCESS);
    }

    @Override
    public ResponseEntity<GeneralResponse<Object>> updateProfiles(String accountId, UpdateProfileRequest request) {
        accountService.updateProfile(accountId, request);
        return responseFactory.response(ResponseStatusEnum.SUCCESS);
    }

    @Override
    public ResponseEntity<GeneralResponse<AccountResponse>> getAccountDetail(String accountId) {
        return responseFactory.response(accountService.getAccountDetail(accountId));
    }
}
