package vn.fpt.edu.cinema.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import vn.fpt.edu.cinema.constant.ResponseStatusEnum;
import vn.fpt.edu.cinema.dto.event.SendEmailEvent;
import vn.fpt.edu.cinema.exception.BusinessException;

import java.util.UUID;

/**
 * vn.fpt.edu.cinema.producer
 *
 * @author : Portgas.D.Ace
 * @created : 12/06/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/

@Service
@Slf4j
public class SendEmailProducer extends Producer{

    private static final String TOPIC = "horo.notification.send_email";
    private ObjectMapper objectMapper;

    @Autowired
    public SendEmailProducer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        super(kafkaTemplate);
        this.objectMapper = objectMapper;
    }

    public void sendMessage(SendEmailEvent event) {
        try {
            String value = objectMapper.writeValueAsString(event);
            super.sendMessage(TOPIC, UUID.randomUUID().toString(), value);
        } catch (JsonProcessingException ex) {
            throw new BusinessException(ResponseStatusEnum.INTERNAL_SERVER_ERROR, "Can't send message to topic "+ TOPIC+" : "+ex.getMessage());
        }
    }
}
