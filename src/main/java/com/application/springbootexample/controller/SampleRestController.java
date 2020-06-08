package com.application.springbootexample.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRestController {

	// inject via application.properties
	@Value("${welcome.message}")
	private String message;

	@RequestMapping("/")
	String welcome() {
		return "Welcome to Learning Spring Boot ..........";
	}

	@RequestMapping("/welcome")
	String welcomeLib() {
		return message;
	}

	@RequestMapping("/msg/{name}")
	public String callwithPathVariable(@PathVariable("name") String myname) {
		return "Hello " + myname;
	}

	
	@RequestMapping("/hello")
	public String callWithRequestParam(@RequestParam(name = "name", required = false, defaultValue = "") String name) {

		return " Thanks For Visiting :  " + name;
	}

}
