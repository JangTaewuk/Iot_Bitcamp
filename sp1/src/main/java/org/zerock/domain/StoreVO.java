package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class StoreVO {
	
	private Integer sno;
	private String name,menu;
	private Double lat,lng;
	private Date regdate; 

}
