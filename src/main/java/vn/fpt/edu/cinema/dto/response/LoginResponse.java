package vn.fpt.edu.cinema.dto.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.fpt.edu.cinema.datetime.CustomDateTimeSerializer;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * vn.fpt.edu.cinema.dto.response
 *
 * @author : Portgas.D.Ace
 * @created : 21/05/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LoginResponse implements Serializable {
    private String accountId;
    private String username;
    private String email;
    private String fullName;
    private String roles;
}
