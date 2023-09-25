package vn.fpt.edu.cinema.datetime;

/**
 * vn.fpt.edu.cinema.datetime
 *
 * @author : Portgas.D.Ace
 * @created : 29/05/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@Configuration
public class LocaleConfig {

    @PostConstruct
    public void init() {

        TimeZone.setDefault(TimeZone.getTimeZone("GMT+7"));

    }

}
