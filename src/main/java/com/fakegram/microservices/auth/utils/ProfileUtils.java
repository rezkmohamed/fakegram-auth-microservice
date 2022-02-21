package com.fakegram.microservices.auth.utils;

import com.fakegram.microservices.auth.dto.ProfileDTO;
import com.fakegram.microservices.auth.entity.Profile;

public class ProfileUtils {
	public static ProfileDTO profileEntityToProfileDTO(Profile profile) {
		ProfileDTO profileDTO = new ProfileDTO();
		profileDTO.setBio(profile.getBio());
		profileDTO.setEmail(profile.getEmail());
		profileDTO.setId(profile.getIdProfile());
		profileDTO.setName(profile.getName());
		profileDTO.setNickname(profile.getNickname());
		profileDTO.setProPic(profile.getProPic());
		
		return profileDTO;
	}
	
	public static Profile profileDTOToProfileEntity(ProfileDTO profileDTO) {
		Profile profile = new Profile();
		profile.setBio(profileDTO.getBio());
		profile.setEmail(profileDTO.getEmail());
		profile.setIdProfile(profileDTO.getId());
		profile.setName(profileDTO.getName());
		profile.setNickname(profileDTO.getNickname());
		profile.setProPic(profileDTO.getProPic());
		profile.setPassword(profileDTO.getPassword());
		
		return profile;
	}
}
