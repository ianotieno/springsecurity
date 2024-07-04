package com.example.jwt_dem.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix= "rsa")
public record RsaKeyProperties() {


}
