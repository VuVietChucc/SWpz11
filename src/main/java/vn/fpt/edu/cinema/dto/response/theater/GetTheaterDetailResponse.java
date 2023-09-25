package vn.fpt.edu.cinema.dto.response.theater;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Lazy;
import vn.fpt.edu.cinema.entity._File;

import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.UUID;

/**
 * vn.fpt.edu.cinema.dto.response.theater
 *
 * @author : Portgas.D.Ace
 * @created : 17/07/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GetTheaterDetailResponse {
    private String theaterId;
    private String theaterName;
    private String region;
    private _File imageFilm;
}
