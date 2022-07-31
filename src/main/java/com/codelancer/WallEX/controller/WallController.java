package com.codelancer.WallEX.controller;

import com.codelancer.WallEX.model.WallModel;
import com.codelancer.WallEX.service.WallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("wallpaper")
public class WallController {

    @Autowired
    WallService wallService;

    @GetMapping("all")
    public List<WallModel> getAllWall(){
        return wallService.getAllWall();
    }

    @GetMapping("{ID}")
    public WallModel getWall(@PathVariable("ID") String id){
        return wallService.getWall(id);
    }
}
