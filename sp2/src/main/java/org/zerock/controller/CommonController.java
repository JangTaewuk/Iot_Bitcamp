package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class CommonController {
	
	
	@GetMapping("/login")
	public void login(@ModelAttribute("error") String error) {
		log.info("Get .............");
		log.info("login page .............");
	}
	

}
