package com.demo.springdemo.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {

	@GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
	public String sayHello() {
		return "Hello-world";
	}
}
