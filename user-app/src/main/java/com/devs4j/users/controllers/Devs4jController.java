package com.devs4j.users.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //Stereotype
@RequestMapping("/hello")
public class Devs4jController {
	
	@GetMapping
	public String HelloWorld() {
		return "Hello World";
		
	}
}
