package com.fakegram.microservices.auth.controller;

import java.util.Enumeration;
import java.util.Map;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;

import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fakegram.microservices.auth.dto.ProfileDTO;
import com.fakegram.microservices.auth.service.ProfileService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

@RestController
@RequestMapping("/auth")
public class ProfileController {
	@Autowired
	private ProfileService profileService;
	
//	private String signingKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzcZqR7mY9KjHDA8YNYfRSrJ7e0gFIB3flqsHynQj1xchdq6nL4nTvhJbkuTIdb76L8McRbDpCQsw8pzy2H2pU3YrK2Nf6SRYOvsN+1j3laXiZZLYllEYF44EzSdGyBjwTVceDKpcvwwDWWi/k/NoeGyJSE7w/j0KTK/P4O1Qgt4uXSNYv9CZCVViJxDL1r5u31BO+pK9iQiop+VDJKoGrxzrfZEhydtu3oVsVXXRlwW1hCradkt1MJLyxGJyc7DIpcLunmrMxsGguqs5cGoYILyWoP2NNMYeNnRKr4SS50Z134qJElr2V4h6BjahpnEykga1brKNMDKQdZm2rLzAEwIDAQAB";
	
	
	@PostMapping("/login")
	public ResponseEntity<ProfileDTO> login(@RequestBody ProfileDTO profileDTO){
		if(profileService.login(profileDTO)) {
			return new ResponseEntity<>(new ProfileDTO("LOGIN SUCCESS", null, null, null, null, null), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/test")
	@RolesAllowed("user")
    public ResponseEntity<HttpStatus> testRole(HttpServletRequest request){
		tokenDecoder(request);
		return new ResponseEntity<>(HttpStatus.OK);
    }
	
	private void tokenDecoder(HttpServletRequest request) {
//		String header = request.getHeader("Authorization");
//		String token = header.replace("Bearer ", "");
//		Jws<Claims> result =  Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token);	
//		System.out.println(result.getBody().getClass());
		KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) request.getUserPrincipal();
	    System.out.println("---- ROLES ----");
	    token.getAccount().getRoles().forEach(System.out::println);
	    System.out.println(token.toString());
	    
	    
	    
//	    Map<String, Object> otherClaims = token.getAccount().getKeycloakSecurityContext().getIdToken().getOtherClaims();
//
//	    Enumeration<String> attributeNames = request.getAttributeNames();
//	    while (attributeNames.hasMoreElements())
//	          System.out.println(attributeNames.nextElement());
//
//	    for(String s : otherClaims.keySet()){
//	            System.out.println(s);
//	            System.out.println(otherClaims.get(s).toString());
//	     }

	     System.out.println("------------");
	}
	
	@PostMapping("/register")
	@RolesAllowed("admin")
	public ResponseEntity<Boolean> register(@RequestBody ProfileDTO profileDTO){
		if(profileService.registerProfile(profileDTO)) {
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
	}
}
