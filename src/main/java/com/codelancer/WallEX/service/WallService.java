package com.codelancer.WallEX.service;


import com.codelancer.WallEX.model.WallModel;
import com.codelancer.WallEX.repo.WallRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WallService {

    @Autowired
    WallRepo wallRepo;

    public WallModel storeWall(MultipartFile file, String category) throws IOException {
        WallModel wallModel = new WallModel(UUID.randomUUID().toString(),
                file.getOriginalFilename(),
                file.getContentType(),
                file.getBytes(),
                category);
        return wallRepo.save(wallModel);
    }

    public WallModel getWall(String id){
        Optional<WallModel> wallModelOptional = wallRepo.findById(id);
        return wallModelOptional.orElse(null);
    }

    public List<WallModel> getAllWall(){
        return wallRepo.findAll();
    }

    public void deleteWall(String id){
        //WallModel wallModel = wallRepo.findById(id).orElseThrow(()-> new IllegalStateException("wallpaper not found"));
        wallRepo.delete(wallRepo.findById(id).orElseThrow(()-> new IllegalStateException("wallpaper not found")));
    }

}
