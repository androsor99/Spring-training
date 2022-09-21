package com.androsor.spring.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import static java.nio.file.StandardOpenOption.*;

/**
 * The {@code ImageService}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 21.09.2022 12:48
 */
@Service
@RequiredArgsConstructor
public class ImageService {

    @Value("${app.image.bucket:G://My_Lerning/work/Spring-Git/Spring-training/images}")
    private final String bucket;

    @SneakyThrows
    public void  upload(String imagePath, InputStream content) {
        Path fullImagePath = Path.of(bucket, imagePath);
        try (content) {
            Files.createDirectories(fullImagePath.getParent());
            Files.write(fullImagePath, content.readAllBytes(), CREATE, TRUNCATE_EXISTING);
        }
    }
}
