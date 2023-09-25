package vn.fpt.edu.cinema.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.fpt.edu.cinema.constant._RoleType;
import vn.fpt.edu.cinema.dto.event.SendEmailEvent;
import vn.fpt.edu.cinema.dto.request.account.*;
import vn.fpt.edu.cinema.dto.response.AccountResponse;
import vn.fpt.edu.cinema.dto.response.CreateAccountResponse;
import vn.fpt.edu.cinema.dto.response.LoginResponse;
import vn.fpt.edu.cinema.entity.Account;
import vn.fpt.edu.cinema.exception.BusinessException;
import vn.fpt.edu.cinema.mapper.AccountMapper;
import vn.fpt.edu.cinema.producer.SendEmailProducer;
import vn.fpt.edu.cinema.repository.AccountRepository;
import vn.fpt.edu.cinema.service.AccountService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

/**
 * vn.fpt.edu.cinema.service.impl
 *
 * @author : Portgas.D.Ace
 * @created : 21/05/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/
@Service
@Slf4j
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final static Integer RECOMMEND_PASSWORD_LENGTH = 8;
    private final AccountRepository accountRepository;

    private final PasswordEncoder passwordEncoder;
    private final SendEmailProducer sendEmailProducer;
    private final AccountMapper accountMapper;

    @Override
    public void init() {
        if (accountRepository.findAccountByEmailOrUsername("admin").isEmpty()) {
            Account account = Account.builder()
                    .email("admin.cinema@gmail.com")
                    .username("admin")
                    .fullName("admin")
                    .password(passwordEncoder.encode("123456"))
                    .roleType(_RoleType.ADMIN.getStatusName())
                    .build();
            try {
                accountRepository.save(account);
            } catch (Exception ex) {
                return;
            }
        }
    }

    @Override
    @Transactional
    public CreateAccountResponse createAccount(CreateAccountRequest request) {
        if (Objects.nonNull(request.getPassword())) {
            request.setPassword(request.getPassword());
        }
        if (accountRepository.findAccountByUsername(request.getUsername()).isPresent()) {
            return null;
        }

        Account account = Account.builder()
                .fullName(request.getFullName())
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roleType(_RoleType.USER.getStatusName())
                .build();

        try {
            account = accountRepository.save(account);
        } catch (Exception ex) {
            return null;
        }

        return CreateAccountResponse.builder()
                .accountId(account.getAccountId())
                .build();
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        try {
            Account account = accountRepository.findAccountByEmailOrUsername(request.getEmailOrUsername())
                    .orElseThrow(null);
            if (Boolean.FALSE.equals(passwordEncoder.matches(request.getPassword(), account.getPassword()))) {
                return null;
            }
            return LoginResponse.builder()
                    .accountId(account.getAccountId())
                    .username(account.getUsername())
                    .fullName(account.getFullName())
                    .email(account.getEmail())
                    .roles(String.valueOf(account.getRoleType()))
                    .build();
        } catch (Exception e) {
            return null;
        }
    }


    @Override
    public LoginResponse loginWithGoogle(String email) {
        Account account = accountRepository.findAccountByEmail(email)
                .orElseThrow(null);
        accountRepository.save(account);
        return LoginResponse.builder()
                .accountId(account.getAccountId())
                .username(account.getUsername())
                .fullName(account.getFullName())
                .email(account.getEmail())
                .build();
    }

    @Override
    public void changeEmail(String id, ChangeEmailRequest request) {
        Account account = accountRepository.findAccountByAccountId(id)
                .orElseThrow(null);

        if (accountRepository.findAccountByEmail(request.getNewEmail()).isPresent()) {
            return;
        }
        account.setEmail(request.getNewEmail());

        try {
            accountRepository.save(account);
            log.info("Change email success");
        } catch (Exception ex) {
            log.error("Change email failed: {}", ex.getMessage());
            return;
        }
    }



    @Override
    public void changePassword(String id, ChangePasswordRequest request) {
        Account account = accountRepository.findAccountByAccountId(id)
                .orElseThrow(null);
        if (Boolean.FALSE.equals(passwordEncoder.matches(request.getOldPassword(), account.getPassword()))) {
           return;
        }
        account.setPassword(passwordEncoder.encode(request.getNewPassword()));
        try {
            accountRepository.save(account);
            log.info("Change password success");
        } catch (Exception ex) {
            return;
        }
    }

    @Override
    public void resetPassword(ResetPasswordRequest request) {
        Account account = accountRepository.findAccountByEmailOrUsername(request.getEmailOrUsername())
                .orElseThrow(null);
        String newPassword = randomPassword();
        account.setPassword(passwordEncoder.encode(newPassword));

        SendEmailEvent sendEmailEvent = SendEmailEvent.builder()
                .sendTo(account.getEmail())
                .bcc(null)
                .cc(null)
                .templateId("6369cc43f258642ab1e18504")
                .params(Map.of("NEW_PASSWORD", newPassword))
                .build();

        sendEmailProducer.sendMessage(sendEmailEvent);

        try {
            accountRepository.save(account);
            log.info("Reset password success");
        } catch (Exception ex) {
            throw new BusinessException("Can't reset password account to database: " + ex.getMessage());
        }
    }

    @Override
    public AccountResponse getAccountDetail(String accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow();
        return accountMapper.mapGetAccountDetailResponse(account);
    }

    @Override
    public void updateProfile(String accountId, UpdateProfileRequest request) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(null);
        if (Objects.nonNull(request.getGender())) {
            account.setGender(request.getGender());
        }
        if (Objects.nonNull(request.getAddress())) {
            account.setAddress(request.getAddress());
        }
        if (Objects.nonNull(request.getDateOfBirth())) {
            account.setDateOfBirth(LocalDateTime.from(LocalDate.from(request.getDateOfBirth())));
        }
        if (Objects.nonNull(request.getPhoneNumber())) {
            account.setPhoneNumber(request.getPhoneNumber());
        }
        try {
            accountRepository.save(account);
            log.info("Update profile success");
        } catch (Exception ex) {
            throw new BusinessException("Can't update account information in database: " + ex.getMessage());
        }
    }

    @Override
    public Page<AccountResponse> getAllAccount(Pageable pageable, String search) {
        Page<Account> accounts = accountRepository.findAll(pageable);
        return accounts.map(accountMapper::mapGetAccountDetailResponse);
    }


    private String randomPassword() {

        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        int[] randomNumber;
        do {
            randomNumber = random.ints(RECOMMEND_PASSWORD_LENGTH * 5L, 48, 122)
                    .filter(x -> x > 97 && x < 122 || x > 65 && x < 90 || x > 48 && x < 57)
                    .toArray();
        } while (randomNumber.length < RECOMMEND_PASSWORD_LENGTH);

        for (int i = 0; i < RECOMMEND_PASSWORD_LENGTH; i++) {
            stringBuilder.append((char) randomNumber[i]);
        }
        return stringBuilder.toString();
    }
}
