package com.bootjpa.example.jpaexample.Helper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {

   // public final String UPLOAD_DIR="/Users/nikhilbutle/SpringBoot/SpringBoot learning/src/main/resources/static/image";
    public final String UPLOAD_DIR=new ClassPathResource("static/image").getFile().getAbsolutePath();

    public FileUploadHelper() throws IOException {

    }

    public boolean isFileUploaded(MultipartFile file){
        boolean isupload=false;

        try {

            //read the data
//            InputStream is = file.getInputStream();
//            byte[] data = new byte[is.available()];
//            is.read(data);
//
//            //write data
//
//            FileOutputStream fos= new FileOutputStream(UPLOAD_DIR + File.separator + file.getOriginalFilename());
//            fos.write(data);
//
//            fos.flush();

            InputStream is=file.getInputStream();
            Path path= Paths.get(UPLOAD_DIR + File.separator + file.getOriginalFilename());

            Files.copy(is,path, StandardCopyOption.REPLACE_EXISTING);

            isupload=true;

        }catch (Exception e)
        {
            e.printStackTrace();
        }


        return isupload;
    }
}
