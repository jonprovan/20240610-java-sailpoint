package com.skillstorm.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.skillstorm.models.Message;

@RestController
@RequestMapping("/message")
public class MessageController {
	
	@Value("${OAUTH_ISSUER}")
	private String issuer;
	
	@Value("${OAUTH_CLIENT_ID}")
	private String clientId;
	
	@Value("${OAUTH_CLIENT_SECRET}")
	private String clientSecret;
	
	@Value("${OAUTH_AUDIENCE}")
	private String audience;
	
	@GetMapping("/token")
	
	// getting our token from the OAuth provider/issuer
	// would change ResponseEntity type as well if you were using a DTO
	public ResponseEntity<String> getToken() {
		RestTemplate template = new RestTemplate();
		// must add headers for this particular provider, or it won't return what we want
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		// in practice, should package this up as some kind of DTO, then send that
		String body = "{"
				+ "\"client_id\":\"" + clientId + "\","
				+ "\"client_secret\":\"" + clientSecret + "\","
				+ "\"audience\":\"" + audience + "\","
				+ "\"grant_type\":\"client_credentials\""
				+ "}";
		HttpEntity<String> entity = new HttpEntity<>(body, headers);
		// if I had a DTO for the response (an object with access_token, expires_in, and token_type properties
		// I'd use MyDTO.class for the last parameter
		return template.exchange(issuer + "oauth/token", HttpMethod.POST, entity, String.class);
	}
	
	@GetMapping("/public")
	public Message getPublicMessage() {
		return new Message("Public message successfully retrieved!");
	}
	
	@GetMapping("/private")
	public Message getPrivateMessage() {
		return new Message("Private message successfully retrieved!");
	}
	
}