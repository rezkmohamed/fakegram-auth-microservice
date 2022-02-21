package com.fakegram.microservices.auth.service;

import com.fakegram.microservices.auth.dto.ProfileDTO;

public interface ProfileService {
	public boolean registerProfile(ProfileDTO profile, String psw);
	
	public ProfileDTO getProfileById(String idProfile);
	
	public boolean updateProfile(ProfileDTO profileDTO);
	
	public boolean login(ProfileDTO profileDTO);
	
//    public boolean updateProfilePswById(String idProfile, String newPsw);
}
