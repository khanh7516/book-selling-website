package com.example.booksellingwebsite.service.impl;

import com.example.booksellingwebsite.entity.ImageFile;
import com.example.booksellingwebsite.exception.BadRequestException;
import com.example.booksellingwebsite.exception.ResourceNotFoundException;
import com.example.booksellingwebsite.repository.ImageFileRepository;
import com.example.booksellingwebsite.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageFileService implements FileService<ImageFile> {

    @Autowired
    private ImageFileRepository imageFileRepository;

    @Override
    public void uploadFile(MultipartFile file) {

        String originalFilename = file.getOriginalFilename().toLowerCase();
        if (!originalFilename.endsWith(".jpeg") && !originalFilename.endsWith(".jpg") && !originalFilename.endsWith(".png")) {
            throw new BadRequestException("Only JPEG and PNG files are allowed.");
        }

        ImageFile image = new ImageFile();
        image.setType(file.getContentType());
        try {
            image.setData(file.getBytes());
        } catch (IOException e) {
            throw new BadRequestException("Cannot read file!"); // Ném lại ngoại lệ IOException
        }
        imageFileRepository.save(image);
    }

    @Override
    public ImageFile getFileById(Integer id) {
        return imageFileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("File not found with id " + id));
    }
}
