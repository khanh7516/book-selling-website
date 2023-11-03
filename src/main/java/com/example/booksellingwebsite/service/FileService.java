package com.example.booksellingwebsite.service;


import com.example.booksellingwebsite.entity.PdfFile;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;

public interface FileService<T> {


    void uploadFile(MultipartFile file);

    T getFileById(Integer id);



}
