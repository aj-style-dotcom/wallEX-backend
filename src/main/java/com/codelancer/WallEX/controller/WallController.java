package com.codelancer.WallEX.controller;

import com.codelancer.WallEX.model.WallpaperModel;
import com.codelancer.WallEX.service.WallpaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("wallpaper")
public class WallController {

    @Autowired
    WallpaperService wallpaperService;

    @GetMapping("all")
    public List<WallpaperModel> getAllWall(){
        return wallpaperService.getAllWall();
    }

    @GetMapping("{ID}")
    public WallpaperModel getWall(@PathVariable("ID") String id){
        return wallpaperService.getWall(id);
    }
}
