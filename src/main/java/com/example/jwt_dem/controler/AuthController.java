package com.example.jwt_dem.controler;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt_dem.Service.TokenService;



@RestController
public class AuthController {
private static final Logger logger= LoggerFactory.getLogger(AuthController.class);

private final TokenService tokenService;
public AuthController(TokenService tokenService){
    this.tokenService=tokenService;
}

}
