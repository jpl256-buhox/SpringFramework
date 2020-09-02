package com.devs4j.users.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devs4j.users.models.User;
import com.devs4j.users.services.UserServiceUsingList;

@RestController
//definicion de recurso
@RequestMapping("/v1/users")
public class UserControllerUsingList {
	
	@Autowired
	private UserServiceUsingList userService;
	
	@GetMapping
	//Metodo HTTP + Recurso ->Handler methods
	public ResponseEntity<List<User>> getUser(@RequestParam(value="startWith",required=false) String startWith){
		return new ResponseEntity<>(userService.getUsers(startWith),HttpStatus.OK);
		
	}
	
	@GetMapping(value="/{username}")
	public ResponseEntity<User> getUserbyUserName(@PathVariable("username") String username){
		return new ResponseEntity<>(userService.getUserbyUserName(username),HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		return new ResponseEntity<>(userService.createUser(user),HttpStatus.OK);
	}

	@PutMapping(value="/{username}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("username") String username){
		return new ResponseEntity<>(userService.updateUser(user, username),HttpStatus.OK);
		
	}

	@DeleteMapping(value="{username}")
	public ResponseEntity<Void> deleteUser(@PathVariable("username") String username) {
		userService.deleteUser(username);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}


