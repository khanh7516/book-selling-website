package com.example.booksellingwebsite.service;


import com.example.booksellingwebsite.entity.ImageFile;
import com.example.booksellingwebsite.entity.PdfFile;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public interface FileService<T> {


    T uploadFile(MultipartFile file, String field);

    T getFileById(Integer id);

    List<T> getFilesOfCurrentUser();

    void deleteFile(Integer id);


}
