package vn.fpt.edu.cinema.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

/**
 * vn.fpt.edu.cinema.service
 *
 * @author : Portgas.D.Ace
 * @created : 21/05/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/

@CacheConfig(cacheNames = "displayMessage")
public interface DisplayMessageService {
    @Cacheable
    String getDisplayMessage(String code);

    @Cacheable
    String getDisplayMessage(String code, String language);

}
