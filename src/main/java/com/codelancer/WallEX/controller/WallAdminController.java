package com.codelancer.WallEX.controller;


import com.codelancer.WallEX.model.WallModel;
import com.codelancer.WallEX.service.WallService;
import com.codelancer.WallEX.util.WallUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("admin")
public class WallAdminController {

    @Autowired
    WallService wallService;

    @Autowired
    WallUtil wallUtil;

    @PostMapping("wall/{CATE}")
    public WallModel addWall(@RequestParam("file") MultipartFile file, @PathVariable("CATE") String category) throws IOException {
        System.out.println(category);
        return wallService.storeWall(file, category);
    }

    @DeleteMapping("wall/{ID}")
    public void deleteWall(@PathVariable("ID") String id){
        wallService.deleteWall(id);
    }

    @PostMapping("wallpaper")
    public ResponseEntity<String> uploadWall(@RequestParam("wallpaper") MultipartFile file){

        if(file.isEmpty())
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("no file atteched");
        
        if(wallUtil.wallUploaded(file)){
            return ResponseEntity.ok("wallpaper uploaded");
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("failed to upload");


    }
}
