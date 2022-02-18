package com.fakegram.microservices.auth.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fakegram.microservices.auth.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, String>{

}
