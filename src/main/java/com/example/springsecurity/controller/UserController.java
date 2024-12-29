package com.example.springsecurity.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping("/user1")
	public String user1() {
		return "user1";
	}

	@GetMapping("/user2")
	public String user2() {
		return "user2";
	}

}
