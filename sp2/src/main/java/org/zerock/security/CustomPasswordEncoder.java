package org.zerock.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomPasswordEncoder implements PasswordEncoder{

	@Override
	public String encode(CharSequence rawPassword) {

		log.info("encode  :"+rawPassword);
		return rawPassword.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {


		
		
		log.info("rawPassword:  "+ rawPassword);
		log.info("encodedPassword:  "+ encodedPassword);
		
		return rawPassword.equals(encodedPassword);
	}

}
