package vn.fpt.edu.cinema.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import vn.fpt.edu.cinema.constant.AppConstant;
import vn.fpt.edu.cinema.entity.DisplayMessage;

import java.util.Objects;
import java.util.Optional;

/**
 * vn.fpt.edu.cinema.repository
 *
 * @author : Portgas.D.Ace
 * @created : 29/05/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/

@Service
@RequiredArgsConstructor
public class DisplayMessageRepositoryImpl implements DisplayMessageRepository{


    @Override
    public Optional<DisplayMessage> findByCodeAndLanguage(String code, String language) {
        if (Objects.isNull(language)){
            language = AppConstant.DEFAULT_LANGUAGE;
        }

//        String displayMessageStr = redisTemplate.opsForValue().get(String.format("%s:%s", code, language));
//        try {
//            return Optional.of(objectMapper.convertValue(displayMessageStr, DisplayMessage.class));
//        }catch (Exception ex) {
//            return Optional.empty();
//        }
        return Optional.empty();
    }
}
