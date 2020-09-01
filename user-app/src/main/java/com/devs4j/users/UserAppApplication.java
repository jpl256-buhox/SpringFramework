package com.devs4j.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devs4j.users.entity.User;
import com.devs4j.users.repositories.UserRepository;
import com.github.javafaker.Faker;

@SpringBootApplication
public class UserAppApplication implements ApplicationRunner{
	
	@Autowired
	public Faker faker;
	
	@Autowired
	public UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(UserAppApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		for(int i=0;i<10;i++) {
			User user = new User();
			user.setUsername(faker.name().username());
			user.setPassword(faker.dragonBall().character());
			user.setProfile(null);
			userRepository.save(user);
		}
		
	}

}
