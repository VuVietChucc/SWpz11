package vn.fpt.edu.cinema.service;

import vn.fpt.edu.cinema.dto.request.banner.CreateBannerRequest;
import vn.fpt.edu.cinema.dto.response.banner.CreateBannerResponse;

/**
 * vn.fpt.edu.cinema.service
 *
 * @author : Portgas.D.Ace
 * @created : 27/06/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/

public interface BannerService {
    CreateBannerResponse createBanner(CreateBannerRequest request);
}
