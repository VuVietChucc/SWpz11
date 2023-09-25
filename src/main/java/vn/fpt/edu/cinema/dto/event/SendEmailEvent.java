package vn.fpt.edu.cinema.dto.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

/**
 * vn.fpt.edu.cinema.dto.event
 *
 * @author : Portgas.D.Ace
 * @created : 12/06/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SendEmailEvent {

    private String templateId;
    private String sendTo;
    private String bcc;
    private String cc;
    private Map<String, String> params;
}
