package com.codelancer.WallEX.controller;


import com.codelancer.WallEX.model.JWTRequest;
import com.codelancer.WallEX.model.JWTResponse;
import com.codelancer.WallEX.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Admin {

    @Autowired
    private AdminService adminService;

    @PostMapping("login")
    public JWTResponse login(@RequestBody JWTRequest jwtRequest){
        return adminService.login(jwtRequest);
    }
}

