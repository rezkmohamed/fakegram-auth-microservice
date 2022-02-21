package com.fakegram.microservices.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fakegram.microservices.auth.dto.ProfileDTO;
import com.fakegram.microservices.auth.service.ProfileService;

@RestController
@RequestMapping("/auth")
public class ProfileController {
	@Autowired
	private ProfileService profileService;
	
	
	@PostMapping("/login")
	public ResponseEntity<ProfileDTO> login(@RequestBody ProfileDTO profileDTO){
		if(profileService.login(profileDTO)) {
			return new ResponseEntity<>(new ProfileDTO("LOGIN SUCCESS", null, null, null, null, null), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/register")
	public ResponseEntity<Boolean> register(@RequestBody ProfileDTO profileDTO){
		if(profileService.registerProfile(profileDTO)) {
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
	}
}
