package com.codelancer.WallEX.service;


import com.codelancer.WallEX.model.WallpaperModel;
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
import java.util.Optional;
import java.util.UUID;

@Service
public class WallpaperService {

    @Autowired
    WallpaperRepo wallpaperRepo;


    public WallpaperModel getWall(String id){
        Optional<WallpaperModel> wallModelOptional = wallpaperRepo.findById(id);
        return wallModelOptional.orElse(null);
    }

    public List<WallpaperModel> getAllWall(){
        return wallpaperRepo.findAll();
    }

    public void deleteWall(String id){
        wallpaperRepo.delete(wallpaperRepo.findById(id).orElseThrow(()-> new IllegalStateException("wallpaper not found")));
    }

    public boolean wallUploaded(MultipartFile file, String category) throws IOException {

        final String DIR_NAME= new ClassPathResource("static/Wallpapers/").getFile().getAbsolutePath();
        boolean uploaded = false;

        try {

            Files.copy(file.getInputStream(), Paths.get(DIR_NAME+ File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);

            String wallUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("Wallpaper")
                    .path(file.getOriginalFilename())
                    .toUriString();

            WallpaperModel wallpaperModel = new WallpaperModel(UUID.randomUUID().toString(), category, wallUrl);

            wallpaperRepo.save(wallpaperModel);

            uploaded=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uploaded;
    }


}
