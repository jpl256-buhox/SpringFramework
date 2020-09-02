package com.devs4j.users.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.devs4j.users.entity.User;
import com.devs4j.users.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getUsers(){
		return userRepository.findAll();
		
	}
	
	public User getUserById(Integer userId) {
		return userRepository.findById(userId).orElseThrow(
				()-> new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("user %d not found", userId)));
	}
}
