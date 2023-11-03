package com.example.booksellingwebsite.service.impl;

import com.example.booksellingwebsite.entity.ImageFile;
import com.example.booksellingwebsite.entity.PdfFile;
import com.example.booksellingwebsite.exception.BadRequestException;
import com.example.booksellingwebsite.exception.ResourceNotFoundException;
import com.example.booksellingwebsite.repository.ImageFileRepository;
import com.example.booksellingwebsite.repository.PdfFileRepository;
import com.example.booksellingwebsite.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PdfFileService implements FileService<PdfFile> {


    @Autowired
    private PdfFileRepository pdfFileRepository;

    @Override
    public void uploadFile(MultipartFile file) {
        String originalFilename = file.getOriginalFilename().toLowerCase();
        if (!originalFilename.endsWith(".pdf")) {
            throw new BadRequestException("Only PDF files are allowed!");
        }

        PdfFile pdf = new PdfFile();
        pdf.setType(file.getContentType());
        try {
            pdf.setData(file.getBytes());
        } catch (IOException e) {
            throw new BadRequestException("Cannot read file!"); // Ném lại ngoại lệ IOException
        }
        pdfFileRepository.save(pdf);
    }

    @Override
    public PdfFile getFileById(Integer id) {
        return pdfFileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("File not found with id " + id));
    }
}
