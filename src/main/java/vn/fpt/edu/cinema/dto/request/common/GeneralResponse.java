package vn.fpt.edu.cinema.dto.request.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * vn.fpt.edu.cinema.dto.common
 *
 * @author : Portgas.D.Ace
 * @created : 21/05/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GeneralResponse<T> implements Serializable {

    private static final long serialVersionUID = -369541457518166195L;
    private _ResponseStatus status;
    private T data;
}
