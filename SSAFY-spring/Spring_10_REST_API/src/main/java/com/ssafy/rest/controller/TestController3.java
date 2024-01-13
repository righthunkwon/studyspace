package com.ssafy.rest.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest3")
public class TestController3 {
	
	// http://localhost:8080/mvc/rest3/test1 
	@GetMapping("/test1") // READ
	public String test1() {
		return "hi GET";
	}

	// http://localhost:8080/mvc/rest3/test2
	@PostMapping("/test2") // CREATE
	public String test2() {
		return "hi POST";
	}
	
	// http://localhost:8080/mvc/rest3/test3
	@PutMapping("/test3") // UPDATE
	public String test3() {
		return "hi PUT";
	}

	// http://localhost:8080/mvc/rest3/test4
	@DeleteMapping("/test4") // DELETE
	public String test4() {
		return "hi DELETE";
	}

}
