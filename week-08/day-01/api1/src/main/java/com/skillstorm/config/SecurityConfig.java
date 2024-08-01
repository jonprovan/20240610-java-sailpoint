package com.skillstorm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;

// this class configures our Basic Authentication security settings for this entire project
// we can set up which endpoints and/or request types require authentication and which don't

// MUST use this annotation for this class, so it can define/generate Beans
@Configuration
public class SecurityConfig {
	
	// the main Bean we need here is a SecurityFilterChain
	// this filters all incoming requests and either approves or denies them without authentication
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		// getting the http object started with basic auth
		// this requires us to throw or handle an Exception
		http.httpBasic(Customizer.withDefaults());
		
		// to set up requests for authentication, we use a pattern matcher
		// -- what URL pattern do we want to authenticate or not
		// used use Ant matchers, but this required too much specificity
		// so now, we use MvcMatcher, which allows for wildcards and easier setup
		http.authorizeHttpRequests(reqs -> {
			// each of these is a request with a url suffix, a request type, and what to do
			// these go from MOST specific to LEAST
			// as soon as a request matches one of these, filtration stops
			// parameters = method(s), suffix with/without wildcards
			// last part is what we want to do with that request
			
			reqs.requestMatchers(HttpMethod.GET, "/message/specific/**").authenticated();
			reqs.requestMatchers(HttpMethod.GET, "/message/api2/**").authenticated();
			// reqs.requestMatchers(HttpMethod.POST, "/message/post/**").permitAll();
			reqs.requestMatchers(HttpMethod.GET, "/message/**").permitAll();
			// reqs.anyRequest().permitAll(); // a catch-all for all other endpoints
		});
		
		return http.build();
	}

}








