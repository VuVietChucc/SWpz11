package vn.fpt.edu.cinema.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import vn.fpt.edu.cinema.dto.request.common.GeneralResponse;
import vn.fpt.edu.cinema.dto.response.FileResponse;

/**
 * vn.edu.fpt.accounts.dto.common
 *
 * @author : Portgas.D.Ace
 * @created : 24/03/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/
@RequestMapping("/public/api/v1/files")
public interface FileController {

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<GeneralResponse<FileResponse>> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("tag") String tag);
}
