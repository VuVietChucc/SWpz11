package vn.fpt.edu.cinema.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import vn.fpt.edu.cinema.constant.ResponseStatusEnum;
import vn.fpt.edu.cinema.dto.request.common.GeneralResponse;
import vn.fpt.edu.cinema.dto.request.common._ResponseStatus;
import vn.fpt.edu.cinema.service.DisplayMessageService;

import java.util.Objects;

/**
 * vn.fpt.edu.cinema.factory
 *
 * @author : Portgas.D.Ace
 * @created : 21/05/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/

@Component
public class ResponseFactory {
    private final DisplayMessageService displayMessageService;

    @Autowired(required = false)
    public ResponseFactory(DisplayMessageService displayMessageService) {
        this.displayMessageService = displayMessageService;
    }

    public <T> ResponseEntity<GeneralResponse<T>> response(T data, ResponseStatusEnum status, String message){
        _ResponseStatus responseStatus = new _ResponseStatus();
        responseStatus.setStatus(status.getStatus());
        responseStatus.setCode(status.getCode());
        if(Objects.nonNull(displayMessageService)){
            responseStatus.setDisplayMessage(displayMessageService.getDisplayMessage(status.getCode()));
        }
        if(Objects.nonNull(message)){
            responseStatus.setMessage(message);
        }

        return ResponseEntity
                .status(status.getStatus())
                .body(createResponse(data, responseStatus));
    }
    public <T> ResponseEntity<GeneralResponse<T>> response(T data, ResponseStatusEnum status){
        return response(data, status, null);
    }

    public <T> ResponseEntity<GeneralResponse<T>> response(T data){
        return response(data, ResponseStatusEnum.SUCCESS, null);
    }

    public ResponseEntity<GeneralResponse<Object>> response(ResponseStatusEnum status, String message){
        return response(null, status, message);
    }

    public ResponseEntity<GeneralResponse<Object>> response(ResponseStatusEnum status){
        return response(null, status, null);
    }

    private <T> GeneralResponse<T> createResponse(T data, _ResponseStatus status){
        GeneralResponse<T> generalResponse = new GeneralResponse<>();
        generalResponse.setStatus(status);
        generalResponse.setData(data);
        return generalResponse;
    }

}
