package vn.fpt.edu.cinema.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * vn.fpt.edu.cinema.config
 *
 * @author : Portgas.D.Ace
 * @created : 29/05/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/

@Configuration
public class BeanConfiguration {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(12);
    }
}
