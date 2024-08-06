package com.skillstorm.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.models.Message;

@RestController
@RequestMapping("/message")
public class MessageController {
	
	@GetMapping("/token")
	public Message getToken() {
		return new Message("eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IlpkT056VjBva25hOW9EYWdKTnp6SyJ9.eyJpc3MiOiJodHRwczovL2Rldi13dXdvajBybjI0dGNqMWUyLnVzLmF1dGgwLmNvbS8iLCJzdWIiOiJyZmdwVHJzMUdBY1pNWFkwUDNWOGZrVG1DRGNxcHdxbUBjbGllbnRzIiwiYXVkIjoiaHR0cHM6Ly9vYXV0aC1kZW1vLXNlcnZlciIsImlhdCI6MTcyMjk1Nzk0NSwiZXhwIjoxNzIzMDQ0MzQ1LCJndHkiOiJjbGllbnQtY3JlZGVudGlhbHMiLCJhenAiOiJyZmdwVHJzMUdBY1pNWFkwUDNWOGZrVG1DRGNxcHdxbSJ9.BrGKj8V47ndnefxAOsckYMvWdJyZbG0FK5PhBv2QHoU5vjCzx1iv_2KKtbu56XlobMkQ8FnZntcDGI34Sxe7ZKQl--ijSvipBTcsfI4a7HCKiC7ZDS8qi_sTaNX23oDBdLFq9VM5IPreV55oO5rnO2L7XphvLNz5k5B7oG9B67VGpo4jXpXe_mbBlCJmaKefjSNgaCYuHdc_qDcxoQjM8aDp_3sO94iXawEcEw0EuKAu89A72E09dUeJjeP7OV0Cb5lO9ASEgRf17ySiZWkElIWJnyHBvLqVX_yeInm6vE2UdSEepTBWALZAVOgrh2QcxUbLi71GwPuKES-D7vomkA");
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