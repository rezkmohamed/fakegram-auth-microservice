package com.fakegram.microservices.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fakegram.microservices.auth.dto.ProfileDTO;
import com.fakegram.microservices.auth.entity.Profile;
import com.fakegram.microservices.auth.repo.ProfileRepository;
import com.fakegram.microservices.auth.utils.ProfileUtils;

@Service
public class ProfileServiceImpl implements ProfileService {
	@Autowired
	private ProfileRepository profileRepo;

	@Override
	public boolean registerProfile(ProfileDTO profile) {
		Profile profileToSave = ProfileUtils.profileDTOToProfileEntity(profile);
		profileToSave.setPassword(profile.getPassword());
		if(profileRepo.save(profileToSave) != null) {
			return true;
		}
		
		return false;
	}

	@Override
	public ProfileDTO getProfileById(String idProfile) {
		Profile p = profileRepo.findById(idProfile).orElse(null);
		if(p != null) {
			return ProfileUtils.profileEntityToProfileDTO(p);
		}
		
		return null;
	}

	@Override
	public boolean updateProfile(ProfileDTO profileDTO) {
		if(profileRepo.save(ProfileUtils.profileDTOToProfileEntity(profileDTO)) != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean login(ProfileDTO profileDTO) {
		Profile p = profileRepo.findByEmail(profileDTO.getEmail());
		if(p != null) {
			if(profileDTO.getPassword().equals(p.getPassword())) {
				return true;
			}
		}
		
		return false;
	}

//	@Override
//	public boolean updateProfilePswById(String idProfile, String newPsw) {
//
//		
//		return false;
//	}
}
