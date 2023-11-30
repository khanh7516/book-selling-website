package com.example.booksellingwebsite.service.impl;

import com.example.booksellingwebsite.entity.ImageFile;
import com.example.booksellingwebsite.entity.User;
import com.example.booksellingwebsite.exception.BadRequestException;
import com.example.booksellingwebsite.exception.ResourceNotFoundException;
import com.example.booksellingwebsite.exception.UserNotFoundException;
import com.example.booksellingwebsite.repository.ImageFileRepository;
import com.example.booksellingwebsite.repository.UserRepository;
import com.example.booksellingwebsite.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.List;

@Service
public class ImageFileService implements FileService<ImageFile> {

    @Autowired
    private ImageFileRepository imageFileRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    public List<ImageFile> getFilesOfCurrentUser() {
        // TODO : Giả định userId = 1, sau này userId chính là user đang login
        Integer userId = 1;
        return imageFileRepository.findByUser_IdOrderByCreatedAtDesc(userId);
    }


    @Override
    public ImageFile uploadFile(MultipartFile file, String field) {

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

        image.setField(field);
        // TODO : Giả định userId = 1, sau này userId chính là user đang login
        Integer userId = 1;

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id " + userId));

        image.setUser(user);
        imageFileRepository.save(image);
        return image;
    }






    @Override
    public ImageFile getFileById(Integer id) {
        return imageFileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("File not found with id " + id));
    }


    @Override
    public void deleteFile(Integer id) {
        ImageFile file = getFileById(id);
        imageFileRepository.delete(file);
    }





}
