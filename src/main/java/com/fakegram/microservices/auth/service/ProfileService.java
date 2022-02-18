package com.fakegram.microservices.auth.service;

import com.fakegram.microservices.auth.dto.ProfileDTO;
import com.fakegram.microservices.auth.entity.Profile;

public interface ProfileService {
	public String saveProfile(Profile profile);
	
	public ProfileDTO getProfileById(String idProfile);
	
	public boolean updateProfile(ProfileDTO profileDTO);
	
//    public boolean updateProfilePswById(String idProfile, String newPsw);
}
