package com.example.jwt_dem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.jwt_dem.config.RsaKeyProperties;


@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class JwtDemApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtDemApplication.class, args);
	}

}
