package vn.fpt.edu.cinema.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * vn.fpt.edu.cinema.dto.response
 *
 * @author : Portgas.D.Ace
 * @created : 12/06/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AccountResponse {
    private String accountId;
    private String fullName;
    private String username;
    private String email;
}
