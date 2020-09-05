package com.devs4j.users.controllers;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devs4j.users.entity.User;
import com.devs4j.users.services.UserService;

import io.micrometer.core.annotation.Timed;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	@Timed("get.users")
	@ApiOperation(value="Get list of users", response=User.class)
	@ApiResponses(value={
			@ApiResponse(code = 200, message = "The record was found"),
			@ApiResponse(code = 400, message = "The record was not found")
	})
	public ResponseEntity<Page<User>> getUsers(@RequestParam(required = false, value="page", defaultValue = "0") int page, @RequestParam(required = false, value="size", defaultValue="1000") int size){
		return new ResponseEntity<>(userService.getUsers(page,size),HttpStatus.OK);
	}
	
	@GetMapping("/usernames")
	public ResponseEntity<Page<String>> getUsersNames(
			@RequestParam(required = false, value="page", defaultValue = "0") int page, 
			@RequestParam(required = false, value="size", defaultValue="1000") int size){
		return new ResponseEntity<>(userService.getUsersnames(page,size),HttpStatus.OK);
	}
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") Integer userId){
		return new ResponseEntity<>(userService.getUserById(userId),HttpStatus.OK);
	}
	
	@GetMapping("/username/{username}")
	public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username){
		return new ResponseEntity<>(userService.getUserByUsername(username),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<User> authenticate (@RequestBody User user){
		return new ResponseEntity<>(userService.getUserByUsernameAndPassword(user.getUsername(),user.getPassword()),HttpStatus.OK);
	}
}
