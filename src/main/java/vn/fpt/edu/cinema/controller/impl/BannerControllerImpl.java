package vn.fpt.edu.cinema.controller.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import vn.fpt.edu.cinema.controller.BannerController;
import vn.fpt.edu.cinema.dto.request.banner.CreateBannerRequest;
import vn.fpt.edu.cinema.dto.request.common.GeneralResponse;
import vn.fpt.edu.cinema.dto.response.banner.CreateBannerResponse;
import vn.fpt.edu.cinema.factory.ResponseFactory;
import vn.fpt.edu.cinema.service.BannerService;

/**
 * vn.fpt.edu.cinema.controller.impl
 *
 * @author : Portgas.D.Ace
 * @created : 27/06/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/
@RestController
@RequiredArgsConstructor
@Slf4j
public class BannerControllerImpl implements BannerController {
    private final ResponseFactory responseFactory;
    private final BannerService bannerService;
    @Override
    public ResponseEntity<GeneralResponse<CreateBannerResponse>> createBanner(CreateBannerRequest request) {
        return responseFactory.response(bannerService.createBanner(request));
    }
}
