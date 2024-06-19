package com.skillstorm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// this is the starting point for our entire application
// notice our main method
// it has a single annotation which comprises three other annotations

/*
 * @EnableAutoConfiguration - eliminates the need for us to manually configure the context/settings
 * @ComponentScan - look through all child packages for Beans
 * @Configuration - allows us to, if we wish, loop in other files for configuration
 * 
 * What is a Bean?
 * - something Spring can automatically manage via an IoC container
 * 
 * What is an IoC Container?
 * - Inversion of Control = leave the instantiation and management of a Bean/object/service/etc. up to the container
 * - we don't have to set it up ourselves
 * - there are several different annotations we'll use to set up different kinds of Bean for different purposes
 * 
 * Not every class is going to be a Bean, mostly just ones we want to inject as dependencies
 * 
 * What is Dependency Injection?
 * - using a Bean of some sort as a dependent set of functionality in a class
 */

@SpringBootApplication
public class SpringappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringappApplication.class, args);
	}

}
