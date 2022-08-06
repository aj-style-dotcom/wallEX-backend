package com.codelancer.WallEX.service;


import com.codelancer.WallEX.model.JWTRequest;
import com.codelancer.WallEX.model.JWTResponse;
import com.codelancer.WallEX.utility.JWTUitil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@Service
public class AdminService {

    @Autowired
    private JWTUitil jwtUitil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetails customUserDetails;

    public JWTResponse login(JWTRequest jwtRequest){
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


