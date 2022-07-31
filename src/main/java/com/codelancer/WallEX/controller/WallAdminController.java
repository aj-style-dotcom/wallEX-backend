package com.codelancer.WallEX.controller;


import com.codelancer.WallEX.model.WallModel;
import com.codelancer.WallEX.service.WallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("admin")
public class WallAdminController {

    @Autowired
    WallService wallService;

    @PostMapping("wall")
    public WallModel addWall(@RequestParam("file") MultipartFile file) throws IOException {
        return wallService.storeWall(file);
    }
}
