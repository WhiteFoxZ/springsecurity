package com.example.springsecurity.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class LoginController {


	@GetMapping("/login")
	public String login() {

		log.debug("login");

		return "login";
	}

	@PostMapping("/loginProc")
	public String loginProc() {

		log.debug("작동하지 않음");

		return "main";
	}

}
