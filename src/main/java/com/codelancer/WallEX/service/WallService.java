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
    WallRepo wallRepoObj;

    public WallModel storeWall(MultipartFile file) throws IOException {
        WallModel wallModelObj = new WallModel(UUID.randomUUID().toString(),
                file.getOriginalFilename(),
                file.getContentType(),
                file.getBytes());
        return wallRepoObj.save(wallModelObj);
    }

    public WallModel getWall(String id){
        Optional<WallModel> wallModelOptional = wallRepoObj.findById(id);
        return wallModelOptional.orElse(null);
    }

    public List<WallModel> getAllWall(){
        return wallRepoObj.findAll();
    }
}
