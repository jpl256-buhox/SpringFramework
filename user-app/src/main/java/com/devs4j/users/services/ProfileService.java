package com.devs4j.users.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.devs4j.users.entity.Profile;
import com.devs4j.users.entity.User;
import com.devs4j.users.repositories.ProfileRepository;
import com.devs4j.users.repositories.UserRepository;

@Service
public class ProfileService {
	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Profile create(Integer userId, Profile profile) {
		Optional <User> result=userRepository.findById(userId);
		if(result.isPresent()) {
			profile.setUser(result.get());
			return profileRepository.save(profile);
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("user %d not found", userId));

	
		}
	}
	public Profile getByUserIdAndProfileId(Integer userId, Integer profileId) {
		return profileRepository.getByUserIdAndProfileId(userId,profileId).orElseThrow(()-> 
			new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("profile not found for user %d and profile %d", userId,profileId)));
	}

}
