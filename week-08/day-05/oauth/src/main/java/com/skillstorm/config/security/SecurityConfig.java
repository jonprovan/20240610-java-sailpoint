package com.skillstorm.config.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.web.SecurityFilterChain;

// this is the actual class where our OAuth is being accessed
// can also include the usual security filters in here as necessary
@Configuration
@EnableMethodSecurity
public class SecurityConfig {
	
	// pulling in our issuer for the JWT decoder
	@Value("${OAUTH_ISSUER}")
	private String issuer;
	
	private AuthenticationErrorHandler authenticationErrorHandler;
	
	public SecurityConfig(AuthenticationErrorHandler authenticationErrorHandler) {
		this.authenticationErrorHandler = authenticationErrorHandler;
	}
	
	@Bean
	public SecurityFilterChain httpSecurity(HttpSecurity http) throws Exception {
		
		return http
				.authorizeHttpRequests(reqs -> {
					reqs.requestMatchers("/message/private").authenticated()
						.anyRequest().permitAll();
				})
				
				.cors(Customizer.withDefaults())
				
				// here's our OAuth, finally!
				.oauth2ResourceServer(oauth2 -> {
					oauth2.jwt(Customizer.withDefaults())
						  .authenticationEntryPoint(authenticationErrorHandler);
				})
				
				.build();
	}
	
	// a bean to decode JWT tokens, using the issuer for our Auth0 account
	@Bean
	JwtDecoder jwtDecoder() {
		// this reaches out to three issuer endpoints to get a decoder
		// whichever one responds first, we stop and use that decoder
		return JwtDecoders.fromIssuerLocation(issuer);
	}

}
