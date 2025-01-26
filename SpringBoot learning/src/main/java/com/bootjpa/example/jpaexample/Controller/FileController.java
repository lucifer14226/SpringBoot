package com.bootjpa.example.jpaexample.Controller;

import com.bootjpa.example.jpaexample.Helper.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class FileController {

    @Autowired
    private FileUploadHelper fileUploadHelper;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file")MultipartFile file)
    {
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        System.out.println(file.getContentType());
        System.out.println(file.getName());

        if(file.isEmpty() || !file.getContentType().equals("image/jpeg"))
        {
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Either the file is Empty or File is not a image pf jpeg type");
        }

        if(fileUploadHelper.isFileUploaded(file)){
            return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
        }

        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Could not upload the file");
    }
}
