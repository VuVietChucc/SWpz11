package vn.fpt.edu.cinema.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import vn.fpt.edu.cinema.constant.ResponseStatusEnum;
import vn.fpt.edu.cinema.dto.request.common.GeneralResponse;
import vn.fpt.edu.cinema.dto.request.common._ResponseStatus;
import vn.fpt.edu.cinema.factory.ResponseFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * vn.fpt.edu.cinema.exception
 *
 * @author : Portgas.D.Ace
 * @created : 29/05/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Autowired
    private ResponseFactory responseFactory;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {
        GeneralResponse<Object> generalResponse = new GeneralResponse<>();
        generalResponse.setStatus(new _ResponseStatus(ResponseStatusEnum.UNAUTHORIZED));
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        OutputStream responseStream = response.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(responseStream, generalResponse);
        responseStream.flush();
    }
}
