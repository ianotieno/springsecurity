package com.example.jwt_dem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private final RsaKeyProperties rsaKeyProperties;
    public SecurityConfig(RsaKeyProperties rsaKeyProperties){
		this.rsaKeyProperties=rsaKeyProperties;
	}
	
	@Bean
	public InMemoryUserDetailsManager user() {
		return new InMemoryUserDetailsManager(User.withUsername("ian")
				.password("{noop}test")
				.authorities("read")
				.build());
				
	}
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		return http
				.csrf(csrf-> csrf.disable())
				.authorizeRequests(auth->auth
				 .anyRequest().authenticated()
						)
 				.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
				.sessionManagement(session ->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.httpBasic(Customizer.withDefaults())
				.build();
	}
	@Bean
	JwtDecoder JwtDecoder(){
		return NimbusJwtDecoder.withPublicKey(rsaKeyProperties.publicKey()).build();
	}

}
