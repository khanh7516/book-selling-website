package com.example.booksellingwebsite.controller.rest;


import com.example.booksellingwebsite.entity.ImageFile;
import com.example.booksellingwebsite.entity.PdfFile;
import com.example.booksellingwebsite.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1")
public class FileRestController<T> {

    private final FileService<ImageFile> imageService;
//    private final FileService<PdfFile> pdfService;

    @Autowired
    public FileRestController(FileService<ImageFile> imageService) {
        this.imageService = imageService;
    }


    @GetMapping("/image")
    public ResponseEntity<?> getFilesOfCurrentUser() {
        return ResponseEntity.ok(imageService.getFilesOfCurrentUser());
    }

    @PostMapping("/image")
    public ResponseEntity<?> uploadImg(@RequestParam("file") MultipartFile file) {

        return ResponseEntity.status(HttpStatus.CREATED).body(imageService.uploadFile(file, "avatar"));
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<?> readImg(@PathVariable Integer id) {
        ImageFile file = imageService.getFileById(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(file.getType()))
                .body(file.getData());
    }


    @DeleteMapping("/image/{id}")
    public ResponseEntity<?> deleteFile(@PathVariable Integer id) {
        imageService.deleteFile(id);
        // Code logic
        return ResponseEntity.noContent().build(); // 204
    }

    @PostMapping("/image/category")
    public ResponseEntity<?> uploadImgCategory(@RequestParam("file") MultipartFile file) {

        return ResponseEntity.status(HttpStatus.CREATED).body(imageService.uploadFile(file, "category"));
    }



//    @PostMapping("/pdf")
//    public ResponseEntity<?> uploadPdf(@RequestParam("file") MultipartFile file){
//        pdfService.uploadFile(file);
//        return ResponseEntity.status(HttpStatus.CREATED).body("File uploaded successfully");
//    }
//
//    @GetMapping("/pdf/{id}")
//    public ResponseEntity<?> readPdf(@PathVariable Integer id) {
//        PdfFile file = pdfService.getFileById(id);
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(file.getType()))
//                .body(file.getData());
//    }

}
