package com.example.springsecurity.controller;

import com.example.springsecurity.entity.User;
import com.example.springsecurity.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class JoinController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping("/join")
	public String login() {
		return "join";
	}

	@PostMapping("/joinProc")
	public String join(User user) {

		log.debug("회원가입 진행 : " + user);
		String rawPassword = user.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		user.setPassword(encPassword);
		user.setRole("ROLE_USER");
		userRepository.save(user);
//		return "redirect:/";
		return "main";

	}

}
