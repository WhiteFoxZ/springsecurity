package com.example.springsecurity.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class IndexController {

	@GetMapping({ "", "/" })
	public String index() {

		log.debug("index : go to main");
		return "main";
	}

}
