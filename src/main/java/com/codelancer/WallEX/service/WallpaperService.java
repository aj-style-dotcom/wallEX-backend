package com.codelancer.WallEX.service;


import com.codelancer.WallEX.model.Wallpaper;
import com.codelancer.WallEX.repo.WallpaperRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Service
public class WallpaperService {

    @Autowired
    WallpaperRepo wallpaperRepo;


    public Wallpaper getWall(String id){
        return wallpaperRepo.findById(id).orElseThrow(()->new IllegalStateException("Wallpaper not found"));
    }

    public List<Wallpaper> getAllWall(){
        return wallpaperRepo.findAll();
    }

    public void deleteWall(String id){
        wallpaperRepo.delete(wallpaperRepo.findById(id).orElseThrow(()-> new IllegalStateException("wallpaper not found")));
    }

    public boolean wallUploaded(MultipartFile file, String category) throws IOException {

        final String DIR_NAME= new ClassPathResource("static/wallpaper/").getFile().getAbsolutePath();
        //final String DIR_NAME= "E:\\bootProject\\Wall-EX\\src\\main\\resources\\static\\Wallpapers";
        boolean uploaded = false;

        try {

            Files.copy(file.getInputStream(), Paths.get(DIR_NAME+ File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);

            String wallUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("wallpaper/")
                    .path(file.getOriginalFilename())
                    .toUriString();

            Wallpaper wallpaper = new Wallpaper(UUID.randomUUID().toString(), category, wallUrl);

            wallpaperRepo.save(wallpaper);

            uploaded=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uploaded;
    }


}
