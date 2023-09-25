package vn.fpt.edu.cinema.dto.request.banner;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * vn.fpt.edu.cinema.dto.request
 *
 * @author : Portgas.D.Ace
 * @created : 27/06/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateBannerRequest {
    private String bannerName;
    private String imageBanner;
}
