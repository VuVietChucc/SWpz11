package vn.fpt.edu.cinema.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.fpt.edu.cinema.dto.request.banner.CreateBannerRequest;
import vn.fpt.edu.cinema.dto.request.common.GeneralResponse;
import vn.fpt.edu.cinema.dto.response.banner.CreateBannerResponse;

/**
 * vn.fpt.edu.cinema.controller
 *
 * @author : Portgas.D.Ace
 * @created : 27/06/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/

@RequestMapping("${app.application-context}/public/api/v1/banner")
public interface BannerController {
    @PostMapping("/create-banner")
    ResponseEntity<GeneralResponse<CreateBannerResponse>> createBanner(@RequestBody CreateBannerRequest request);
}
