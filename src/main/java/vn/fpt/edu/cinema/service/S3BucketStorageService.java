package vn.fpt.edu.cinema.service;

import org.springframework.web.multipart.MultipartFile;
import vn.fpt.edu.cinema.dto.request.account.CreateFileRequest;
import vn.fpt.edu.cinema.entity._File;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * vn.edu.fpt.accounts.service
 *
 * @author : Portgas.D.Ace
 * @created : 21/05/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/

public interface S3BucketStorageService {
    void uploadFile(CreateFileRequest request, String fileKey);
    _File uploadFile(CreateFileRequest request);
    String uploadFile(MultipartFile file);
    void downloadFile(String fileKey, HttpServletResponse response);
    void downloadFile(_File file, HttpServletResponse response);
    File downloadFile(String fileKey);
    String sharingUsingPresignedURL(String fileKey);
    // deleteFile
}
