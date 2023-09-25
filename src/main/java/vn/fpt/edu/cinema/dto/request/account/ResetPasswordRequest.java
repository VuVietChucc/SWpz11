package vn.fpt.edu.cinema.dto.request.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * vn.fpt.edu.cinema.dto.request
 *
 * @author : Portgas.D.Ace
 * @created : 12/06/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResetPasswordRequest implements Serializable {

    private static final long serialVersionUID = -5219107503526276069L;
    private String emailOrUsername;
}
