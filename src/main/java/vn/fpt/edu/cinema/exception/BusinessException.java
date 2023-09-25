package vn.fpt.edu.cinema.exception;

import lombok.Getter;
import vn.fpt.edu.cinema.constant.ResponseStatusEnum;

/**
 * vn.fpt.edu.cinema.exception
 *
 * @author : Portgas.D.Ace
 * @created : 21/05/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/
@Getter
public class BusinessException extends RuntimeException{

    private static final long serialVersionUID = -7568326660433031236L;
    private String message;
    private ResponseStatusEnum status;

    public BusinessException(String message){
        this.status = ResponseStatusEnum.INTERNAL_SERVER_ERROR;
        this.message = message;
    }

    public BusinessException(ResponseStatusEnum status, String message){
        this.status = status;
        this.message = message;
    }
}
