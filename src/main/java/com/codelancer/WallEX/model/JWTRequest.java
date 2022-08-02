package com.codelancer.WallEX.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JWTRequest {
    String username;
    String password;
}
