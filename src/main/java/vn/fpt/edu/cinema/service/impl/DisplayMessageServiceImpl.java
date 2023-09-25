package vn.fpt.edu.cinema.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import vn.fpt.edu.cinema.entity.DisplayMessage;
import vn.fpt.edu.cinema.repository.DisplayMessageRepository;
import vn.fpt.edu.cinema.service.DisplayMessageService;

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
public class DisplayMessageServiceImpl implements DisplayMessageService {
    private final DisplayMessageRepository displayMessageRepository;

    @Override
    public String getDisplayMessage(String code) {
        return getDisplayMessage(code, LocaleContextHolder.getLocale().getLanguage());
    }

    @Override
    public String getDisplayMessage(String code, String language) {
        DisplayMessage displayMessage = displayMessageRepository.findByCodeAndLanguage(code, language)
                .orElse(null);
        return displayMessage == null
                ? null
                : displayMessage.getMessage();
    }
}
