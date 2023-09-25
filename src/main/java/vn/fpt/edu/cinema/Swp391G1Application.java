package vn.fpt.edu.cinema;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
import vn.fpt.edu.cinema.service.AccountService;

@EnableFeignClients
@EnableJpaAuditing
@SpringBootApplication
@EnableScheduling
@OpenAPIDefinition(info = @Info(title = "Cinema Manager ", version = "1.0"),
        servers = {@Server(url = "/", description = "Default Server URL")})
public class Swp391G1Application {

    @Autowired
    private AccountService accountService;
    public static void main(String[] args) {
        SpringApplication.run(Swp391G1Application.class, args);
    }
    @EventListener(ApplicationReadyEvent.class)
    public void initDefaultData(){
        accountService.init();
    }
}
