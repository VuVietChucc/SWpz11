package vn.fpt.edu.cinema.controller.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import vn.fpt.edu.cinema.controller.FileController;
import vn.fpt.edu.cinema.dto.request.common.GeneralResponse;
import vn.fpt.edu.cinema.dto.response.FileResponse;
import vn.fpt.edu.cinema.entity._File;
import vn.fpt.edu.cinema.factory.ResponseFactory;
import vn.fpt.edu.cinema.repository.FileRepository;
import vn.fpt.edu.cinema.service.S3BucketStorageService;

/**
 * vn.edu.fpt.accounts.dto.common
 *
 * @author : Portgas.D.Ace
 * @created : 21/05/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/
@RestController
@RequiredArgsConstructor
@Slf4j
public class FileControllerImpl implements FileController {

    private final S3BucketStorageService s3BucketStorageService;
    private final FileRepository fileRepository;
    private final ResponseFactory responseFactory;

    @Override
    public ResponseEntity<GeneralResponse<FileResponse>> uploadFile(MultipartFile request, String tag) {
        _File file = _File.builder()
                .fileKey(s3BucketStorageService.uploadFile(request))
                .fileName(request.getOriginalFilename())
                .tag(tag)
                .type(request.getContentType())
                .size(request.getSize())
                .build();
        fileRepository.save(file);
        return responseFactory.response(FileResponse.builder()
                .fileId(file.getFileId())
                .fileName(file.getFileName())
                .tag(tag)
                .type(file.getType())
                .size(file.getSize())
                .publicURL(s3BucketStorageService.sharingUsingPresignedURL(file.getFileKey()))
                .build());
    }
}
