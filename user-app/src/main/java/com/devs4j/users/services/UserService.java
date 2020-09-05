package com.devs4j.users.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.devs4j.users.entity.User;
import com.devs4j.users.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Page<User> getUsers(int page, int size){
		return userRepository.findAll(PageRequest.of(page, size));
		
	}
	
	public Page<String> getUsersnames(int page, int size){
		return userRepository.findByUsernames(PageRequest.of(page, size));
		
	}
	
	public User getUserById(Integer userId) {
		return userRepository.findById(userId).orElseThrow(
				()-> new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("user %d not found", userId)));
	}
	
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username).orElseThrow(
				()-> new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("user %d not found", username)));
	}

	
	public User getUserByUsernameAndPassword(String username, String password) {
		return userRepository.findByUsernameAndPassword(username,password).orElseThrow(
				()-> new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("user %d not found", username)));
	}
	
}
