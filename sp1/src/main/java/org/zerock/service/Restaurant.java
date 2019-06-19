package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@ToString
@Log4j
@Service
@AllArgsConstructor
public class Restaurant {
	
//	@Setter(onMethod_= @Autowired)
	private Chef chef;

	
	public void order() {
		log.info(chef.cook());
	}


//
//	@Autowired
//	public void setChef(Chef chef) {
//		this.chef = chef;
//	}
	

}
