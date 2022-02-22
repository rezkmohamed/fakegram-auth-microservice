package com.fakegram.microservices.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fakegram.microservices.auth.dto.ProfileDTO;
import com.fakegram.microservices.auth.service.ProfileService;

@RestController
@RequestMapping("/auth/profiles")
public class ProfileCRUDController {
	@Autowired
	private ProfileService profileService;
	
	@GetMapping("/{idProfile}")
	public ResponseEntity<ProfileDTO> getProfile(@PathVariable String idProfile){
		ProfileDTO profileDTO = profileService.getProfileById(idProfile);
		if(profileDTO != null) {
			return new ResponseEntity<>(profileDTO, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
}
