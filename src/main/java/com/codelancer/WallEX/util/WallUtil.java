package com.codelancer.WallEX.util;


import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class WallUtil {
    
    public final String DIR_NAME="C:\\Users\\ankit\\Desktop\\bootProject\\Wall-EX\\src\\main\\resources\\static\\Wallpapers";

    public boolean wallUploaded(MultipartFile file) {
        boolean uploaded = false;

        try {

            Files.copy(file.getInputStream(), Paths.get(DIR_NAME+ File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);

            uploaded=true;
            



        } catch (Exception e) {
            e.printStackTrace();
        }





        return uploaded;
    }





}


