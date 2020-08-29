/**
 * 
 */
package com.devs4j.users.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.javafaker.Faker;

/**
 * @author Buhox
 *
 */

@Configuration
public class FakerBeanConfig {
	
	@Bean
	public Faker fakerBean() {
		return new Faker();
		
	}

}
