package com.codelancer.WallEX.controller;


import com.codelancer.WallEX.model.JWTRequest;
import com.codelancer.WallEX.model.JWTResponse;
import com.codelancer.WallEX.service.CustomUserDetails;
import com.codelancer.WallEX.utility.JWTUitil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Admin {

    @Autowired
    private JWTUitil jwtUitil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetails customUserDetails;

    @PostMapping("login")
    public JWTResponse login(@RequestBody JWTRequest jwtRequest){

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()
                    )
            );

        }catch (Exception e){
            e.printStackTrace();
        }

        UserDetails userDetails = customUserDetails.loadUserByUsername(jwtRequest.getUsername());
        String token = jwtUitil.generateToken(userDetails);

        return new JWTResponse(token);
    }
}
