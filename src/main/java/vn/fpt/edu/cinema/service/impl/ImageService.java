package vn.fpt.edu.cinema.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.fpt.edu.cinema.dto.response.ImageResponse;
import vn.fpt.edu.cinema.entity._File;
import vn.fpt.edu.cinema.repository.FileRepository;
import vn.fpt.edu.cinema.service.S3BucketStorageService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImageService {

    private final S3BucketStorageService s3BucketStorageService;
    private final FileRepository fileRepository;

    public List<ImageResponse> getImagePublicUrl(String tag){
        List<_File> files = fileRepository.findAllByTag(tag);
        return files.stream().filter(Objects::nonNull)
                .map(file -> ImageResponse.builder()
                        .name(file.getFileName())
                        .url(s3BucketStorageService.sharingUsingPresignedURL(file.getFileKey()))
                        .build())
                .collect(Collectors.toList());
    }
}
